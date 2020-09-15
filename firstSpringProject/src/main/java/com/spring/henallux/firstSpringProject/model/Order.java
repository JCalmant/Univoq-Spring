package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Order {
    @NotNull
    @Size(min=0,max=8)
    private Integer id;
    @NotNull
    private User user;

    public Order(){}
    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
}
