package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
@Entity
@Table(name = "TRANSLATIONCATEGORY")
public class TranslationCategoryEntity {

    @Id
    @Column(name = "translateid")
    private Integer id;
    @Column(name="categoryname")
    private String name;
    @JoinColumn(name="idcategory", referencedColumnName = "categoryid")
    @ManyToOne
    private CategoryEntity category;
    @JoinColumn(name="idlanguage", referencedColumnName = "languageid")
    @ManyToOne
    private LanguageEntity language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public CategoryEntity getCategory() {
        return category;
    }
}
