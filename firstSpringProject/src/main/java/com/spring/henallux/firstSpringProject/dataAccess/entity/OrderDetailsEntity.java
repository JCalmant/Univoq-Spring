package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetails")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderdetailsid")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "unitprice")
    private Double realPrice;
    @JoinColumn(name="idorder", referencedColumnName = "orderid")
    @ManyToOne
    private OrderEntity order;
    @JoinColumn(name="idproduct", referencedColumnName = "productid")
    @ManyToOne
    private ProductEntity product;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public void setProduct(ProductEntity product) {
        this.product= product;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}