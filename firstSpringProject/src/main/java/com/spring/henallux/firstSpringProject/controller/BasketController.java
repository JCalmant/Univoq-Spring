package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDetailsDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.model.Order;
import com.spring.henallux.firstSpringProject.model.OrderDetails;
import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.Constants;
import com.spring.henallux.firstSpringProject.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value="/basket")
@SessionAttributes({Constants.LOG, Constants.CURRENT_USER})
public class BasketController {
    private OrderDetailsDAO orderDetailsDAO;
    private UserDAO userDAO;

    @Autowired
    public BasketController(OrderDetailsDAO orderDetailsDAO, UserDAO userDAO){
        this.orderDetailsDAO=orderDetailsDAO;
        this.userDAO=userDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @ModelAttribute(Constants.LOG)
    public SessionService sessionService(){
        return new SessionService();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String basket (Model model, @ModelAttribute(value=Constants.LOG)SessionService sessionService,
                          Locale locale, @ModelAttribute(value = Constants.CURRENT_USER)User user){
        model = WelcomeController.menu(model,sessionService);
        model.addAttribute("basket",sessionService.getBasket());
        model.addAttribute("changeBasket", new OrderDetails());
        model.addAttribute("isLogged",sessionService.getLogged());
        if(sessionService.getLogged()){
            user=userDAO.getUser(user.getName());
        }
        return "integrated:basket";
    }

    @RequestMapping (value="/updateBasket",method = RequestMethod.POST)
    public String getFormData (@ModelAttribute(value="changeBasket") OrderDetails order,
                               @ModelAttribute(value=Constants.LOG) SessionService sessionService){
        sessionService.setCurrentProduct(order.getProduct().getId());
        return "redirect:/products/item";
    }

    @RequestMapping(value="/connection", method = RequestMethod.POST)
    public String connection(){
        return "redirect:/userConnection";
    }

    @RequestMapping(value="/buy", method = RequestMethod.GET)
    public String buy(@ModelAttribute(value = Constants.LOG)SessionService sessionService,
                      @ModelAttribute(value = Constants.CURRENT_USER)User user){
        Order order = new Order();
        ArrayList<OrderDetails> orderDetails= new ArrayList<>();
        user = userDAO.getUser(user.getName());
        order.setUser(user);
        for(Object entry : sessionService.getBasket().entrySet()) {
            orderDetails.add((( Map.Entry<String, OrderDetails>)entry).getValue());
        }
        orderDetailsDAO.save(orderDetails,order);
        sessionService.setBasket(new HashMap<>());
        return "redirect:/";
    }
}