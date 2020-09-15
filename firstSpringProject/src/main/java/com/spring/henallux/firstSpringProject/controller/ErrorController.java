package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.service.Constants;
import com.spring.henallux.firstSpringProject.service.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/baderror")
@SessionAttributes({Constants.LOG})
public class ErrorController {

    @ModelAttribute(Constants.LOG)
    public SessionService sessionService(){
        return new SessionService();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value=Constants.LOG)SessionService sessionService){
        model = WelcomeController.menu(model,sessionService);
        return "integrated:error";
    }
}