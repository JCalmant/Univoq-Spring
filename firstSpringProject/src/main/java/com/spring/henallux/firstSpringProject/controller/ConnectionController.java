package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.Constants;
import com.spring.henallux.firstSpringProject.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/userConnection")
@SessionAttributes({Constants.CURRENT_USER,Constants.LOG})
public class ConnectionController {

    private UserDAO userDAO;
    private static int nbConnection=0;

    @Autowired
    public ConnectionController(UserDAO userDAO){
        this.userDAO=userDAO;
    };

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }
    @ModelAttribute(Constants.LOG)
    public SessionService sessionService(){
        return new SessionService();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value=Constants.LOG)SessionService sessionService){
        model = WelcomeController.menu(model,sessionService);
        model.addAttribute("isWrongID",nbConnection==0);
        model.addAttribute("profilConnection", new User());
        return "integrated:connection";
    }

    @RequestMapping (value="/sendConnection",method = RequestMethod.POST)
    public String getFormData (Model model,
                               @ModelAttribute(value=Constants.LOG)SessionService sessionService,
                               @ModelAttribute(value=Constants.CURRENT_USER) User user, final BindingResult errors){

            if(userDAO.connectionValidation(user)){
                sessionService.setIsLogged(true);
                nbConnection=0;
                return "redirect:/";
            }
            nbConnection++;
            return "redirect:/userConnection";


    }
}