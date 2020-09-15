package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.NotNull;

public class TranslationProduct {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Product product;
    @NotNull
    private Language language;
    public TranslationProduct(){}

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Language getLanguage() {
        return language;
    }
}
