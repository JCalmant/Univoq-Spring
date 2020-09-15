package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.model.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SessionService {
    private Boolean isLogged;
    private Integer currentCategory;
    private Integer currentProduct;
    private HashMap<String, OrderDetails> basket;

    public SessionService(){
        basket=new HashMap<>();
        isLogged=false;
    }

    public void setIsLogged(Boolean isLogged){
        this.isLogged=isLogged;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public Integer getCurrentCategory() {
        return currentCategory;
    }

    public Integer getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentCategory(Integer currentCategory) {
        this.currentCategory = currentCategory;
    }

    public void setCurrentProduct(Integer currentProduct) {
        this.currentProduct = currentProduct;
    }

    public HashMap getBasket() {
        return basket;
    }

    public void setBasket(HashMap basket) {
        this.basket = basket;
    }
}
