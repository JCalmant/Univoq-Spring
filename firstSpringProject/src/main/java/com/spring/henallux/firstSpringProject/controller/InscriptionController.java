package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.LocalityDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.Constants;
import com.spring.henallux.firstSpringProject.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value="/userInscription")
@SessionAttributes({Constants.CURRENT_USER, Constants.LOG})
public class InscriptionController {
    private UserDAO userDAO;
    private LocalityDAO localityDAO;
    private static ArrayList<String> erreurs;

    @ModelAttribute(Constants.CURRENT_USER)
    public User user()
    {
        return new User();
    }

    @ModelAttribute(Constants.LOG)
    public SessionService sessionService(){
        return new SessionService();
    }

    @Autowired
    public InscriptionController(UserDAO userDAO, LocalityDAO localityDAO) {
        this.userDAO = userDAO;
        this.localityDAO = localityDAO;
        if(erreurs==null)erreurs=new ArrayList<>();
    }

    private Model commonGet(Model model,SessionService sessionService){
        model = WelcomeController.menu(model,sessionService);
        model.addAttribute("profilInscription", new User());
        model.addAttribute("localities",localityDAO.getAllLocality());
        model.addAttribute("erreurs",erreurs);
        erreurs=new ArrayList<>();
        return model;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model,@ModelAttribute(value = Constants.LOG) SessionService sessionService){
        model=commonGet(model,sessionService);
        model.addAttribute("areCorrectsFields",true);
        return "integrated:inscription";
    }

    @RequestMapping (value="/sendInscription",method = RequestMethod.POST)
    public String getFormData (@ModelAttribute(value=Constants.CURRENT_USER) @Valid User user, final BindingResult errors){
        User userVerif = null;
        try {
            if (!user.getName().equals("")) userVerif = userDAO.getUser(user.getName());
        }
        catch (Exception e){}

        if(user.getName().equals("") || userVerif!=null || errors.hasErrors() ||
                user.getFirstName().equals("") || user.getLastName().equals("") ||
                user.getDeliveryAddress().equals("") ||
                !user.getMail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){

            if(userVerif!=null ||  user.getName().equals(""))erreurs.add("usernameError");

            if(user.getFirstName().equals(""))erreurs.add("firstNameError");

            if(user.getLastName().equals(""))erreurs.add("lastNameError");

            if(!user.getConfirmPassword().equals(user.getPassword()) || user.getConfirmPassword().equals(""))erreurs.add("confirmPasswordError");

            if(user.getDeliveryAddress().equals(""))erreurs.add("deliveryAddressError");

            if(!user.getMail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"))
                erreurs.add("mailError");

            return "redirect:/userInscription/badFields";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if(user.getPhoneNumber().equals("")) user.setPhoneNumber(null);
        if(user.getBillingAddress().equals("")) user.setBillingAddress(null);
        userDAO.save(user);
        return "redirect:/";
    }

    @RequestMapping(value="/badFields",method = RequestMethod.GET)
    public String badFields (Model model, @ModelAttribute(value = Constants.LOG) SessionService sessionService){
        model = commonGet(model,sessionService);
        model.addAttribute("areCorrectsFields",false);
        return "integrated:inscription";
    }

}
