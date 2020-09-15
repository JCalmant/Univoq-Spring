package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.NotNull;

public class Language {
    @NotNull
    private Integer id;

    public Language(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
