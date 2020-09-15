package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.*;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.Constants;
import com.spring.henallux.firstSpringProject.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(value="")
@SessionAttributes({Constants.CURRENT_USER, Constants.LOG})
public class WelcomeController {

    private TranslationProductDAO translationProductDAO;
    private ProductDAO productDAO;
    private OrderDetailsDAO orderDetailsDAO;
    private UserDAO userDAO;

    @Autowired
    public WelcomeController(TranslationProductDAO translationProductDAO, ProductDAO productDAO, OrderDetailsDAO orderDetailsDAO, UserDAO userDAO) {
        this.translationProductDAO = translationProductDAO;
        this.productDAO = productDAO;
        this.orderDetailsDAO = orderDetailsDAO;
        this.userDAO = userDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @ModelAttribute(Constants.LOG)
    public SessionService sessionService(){
        return new SessionService();
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model,
                        @ModelAttribute(value = Constants.CURRENT_USER)User user,
                        @ModelAttribute(value=Constants.LOG)SessionService sessionService,
                        Locale locale){
        model = menu(model, sessionService);
        model.addAttribute("testConnection",!sessionService.getLogged());
        model.addAttribute("profilConnection", new User());
        if(sessionService.getLogged()){
            user = userDAO.getUser(user.getName());
            model.addAttribute("username",user.getName());
        }
        return "integrated:welcome";
    }

    @RequestMapping (value = "/contact",method = RequestMethod.GET)
    public String contact (Model model, @ModelAttribute(value = Constants.LOG)SessionService sessionService){
        model=menu(model,sessionService);
        return "integrated:contact";
    }

    public static Model menu (Model model, SessionService sessionService){
        model.addAttribute("title","univoq.me");
        model.addAttribute("connection",sessionService.getLogged());
        return model;
    }

    @RequestMapping (value="/disconnection", method = RequestMethod.POST)
    public String logOut (@ModelAttribute(value=Constants.LOG)SessionService sessionService){
        sessionService.setIsLogged(false);
        return "redirect:/";
    }

    @RequestMapping (value="/menu",method = RequestMethod.POST)
    public String menu (@RequestParam(value="actionMenu") String action,
                        @ModelAttribute(value = Constants.LOG) SessionService sessionService){
        String page;
        switch(action){
            case "Registration":
            case "Inscription":
                page="redirect:/userInscription";
                break;
            case "Contact":
                page="redirect:/contact";
                break;
            case "Profil":
                page="redirect:/profil";
                break;
            case "Boutique":
            case "Store":
                page="redirect:/catalog";
                break;
            case "Basket":
            case "Panier":
                page="redirect:/basket";
                break;
            case "Disconnection":
            case "Déconnexion":
                sessionService.setIsLogged(false);
                page = "redirect:/";
                break;
            default:page="redirect:/userConnection";
        }
        return page;
    }

}
