package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.NotNull;

public class TranslationCategory {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Category category;
    @NotNull
    private Language language;

    public TranslationCategory(){}

    public Language getLanguage() {
        return language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
