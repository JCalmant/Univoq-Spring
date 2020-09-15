package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @Column(name = "productid")
    private Integer id;
    @Column(name = "productprice")
    private Double price;
    @Column(name="productimage")
    private String image;
    @JoinColumn(name="idcategory", referencedColumnName = "categoryid")
    @ManyToOne
    private CategoryEntity category;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}