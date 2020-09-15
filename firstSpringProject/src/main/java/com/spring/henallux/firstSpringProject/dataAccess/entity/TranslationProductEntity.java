package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "TRANSLATIONPRODUCT")
public class TranslationProductEntity {
    @Id
    @Column(name = "translateid")
    private Integer id;
    @Column(name="productname")
    private String name;
    @Column(name="productdescription")
    private String description;
    @JoinColumn(name="idproduct", referencedColumnName = "productid")
    @ManyToOne
    private ProductEntity product;
    @JoinColumn(name="idlanguage", referencedColumnName = "languageid")
    @ManyToOne
    private LanguageEntity language;

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return id;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public void setID(Integer id) {
        this.id = id;
    }
}