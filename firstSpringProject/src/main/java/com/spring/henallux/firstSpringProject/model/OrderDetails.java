package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderDetails {
    @NotNull
    private Integer id;
    @NotNull
    private Order order;
    @NotNull
    private Product product;
    @NotNull
    @Min(value = 1)
    private Integer quantity;
    @NotNull
    private Double realPrice;

    public OrderDetails(){}

    public OrderDetails(Integer id, Order order, Product product, Integer quantity, Double realPrice){
        setId(id);
        setOrder(order);
        setProduct(product);
        setQuantity(quantity);
        setRealPrice(realPrice);
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public String getTot(){
        return String.format("%.2f",quantity*realPrice);
    }
}
