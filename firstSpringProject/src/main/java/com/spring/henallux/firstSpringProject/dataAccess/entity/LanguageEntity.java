package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class LanguageEntity {
    @Id
    @Column(name="languageid")
    private Integer id;
    @Column(name="languagename")
    private String name;
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}