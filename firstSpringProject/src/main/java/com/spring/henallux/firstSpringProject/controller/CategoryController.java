package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.TranslationCategoryDAO;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.service.Constants;
import com.spring.henallux.firstSpringProject.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@Controller
@RequestMapping(value="/catalog")
@SessionAttributes({Constants.LOG})
public class CategoryController {
    private TranslationCategoryDAO translationCategoryDAO;

    @Autowired
    public CategoryController(TranslationCategoryDAO translationCategoryDAO){
        this.translationCategoryDAO = translationCategoryDAO;
    }

    @ModelAttribute(Constants.LOG)
    public SessionService sessionService(){
        return new SessionService();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, @ModelAttribute(value=Constants.LOG)SessionService sessionService, Locale locale){
        model = WelcomeController.menu(model,sessionService);
        model.addAttribute("categories",translationCategoryDAO.getAllCategory(locale.getLanguage()));
        model.addAttribute("categoryRedirection",new Category());
        return "integrated:category";
    }

    @RequestMapping (value="/choosenCategory",method = RequestMethod.POST)
    public String getFormData (@ModelAttribute(value="categoryRedirection") Category category,
                               @ModelAttribute(value=Constants.LOG) SessionService sessionService){
        sessionService.setCurrentCategory(category.getId());
        return "redirect:/products/list";
    }
}
