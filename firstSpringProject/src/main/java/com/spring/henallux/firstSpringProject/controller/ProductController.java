package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.TranslationProductDAO;
import com.spring.henallux.firstSpringProject.model.OrderDetails;
import com.spring.henallux.firstSpringProject.model.TranslationProduct;
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
@RequestMapping(value="/products")
@SessionAttributes({Constants.LOG})
public class ProductController {
    private TranslationProductDAO translationProductDAO;

    @Autowired
    public ProductController(TranslationProductDAO translationProductDAO){
        this.translationProductDAO = translationProductDAO;
    }

    @ModelAttribute(Constants.LOG)
    public SessionService sessionService(){
        return new SessionService();
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String list (Model model, @ModelAttribute(value=Constants.LOG)SessionService sessionService,
                        Locale locale){
        model = WelcomeController.menu(model,sessionService);
        model.addAttribute("products",translationProductDAO.getAll(locale.getLanguage(),sessionService.getCurrentCategory()));
        model.addAttribute("productRedirection",new TranslationProduct());
        return "integrated:product";
    }

    @RequestMapping(value="/item",method = RequestMethod.GET)
    public String item (Model model, @ModelAttribute(value=Constants.LOG)SessionService sessionService,
                        Locale locale){
        TranslationProduct translationProduct=translationProductDAO.getById(sessionService.getCurrentProduct());
        model = WelcomeController.menu(model,sessionService);
        model.addAttribute("imgProduct",translationProduct.getProduct().getImage());
        model.addAttribute("productName",translationProduct.getName());
        model.addAttribute("productDescription",translationProduct.getDescription());
        model.addAttribute("productPrice",translationProduct.getProduct().getPrice());
        model.addAttribute("productsToBasket",new OrderDetails());
        return "integrated:selectedItem";
    }

    @RequestMapping (value="/choosenProduct",method = RequestMethod.POST)
    public String getFormData (@ModelAttribute(value="productRedirection") TranslationProduct product,
                               @ModelAttribute(value=Constants.LOG) SessionService sessionService){
        sessionService.setCurrentProduct(product.getId());
        return "redirect:/products/item";
    }

    @RequestMapping (value="/addToBasket",method = RequestMethod.POST)
    public String getFormOrder (@ModelAttribute(value="productsToBasket") OrderDetails orderDetails,
                                @ModelAttribute(value=Constants.LOG) SessionService sessionService){
        TranslationProduct translationProduct=translationProductDAO.getById(sessionService.getCurrentProduct());
        orderDetails.setProduct(translationProduct.getProduct());
        if(orderDetails.getQuantity()!=null) {
            if (orderDetails.getQuantity() == 0 && sessionService.getBasket().containsKey(translationProduct.getName()))
            {
                sessionService.getBasket().remove(translationProduct.getName());
            }
            else {
                sessionService.getBasket().put(translationProduct.getName(), orderDetails);
            }
        }
        return "redirect:/basket";
    }
}