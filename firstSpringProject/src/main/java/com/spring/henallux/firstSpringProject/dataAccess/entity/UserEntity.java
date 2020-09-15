package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserEntity{
    @Id
    @Column(name="username")
    private String name;
    @Column(name="userpassword")
    private String password;
    @Column(name="userfirstname")
    private String firstName;
    @Column(name="userlastname")
    private String lastName;
    @Column(name="usermail")
    private String mail;
    @Column(name="userphonenumber")
    private String phoneNumber;
    @Column(name = "userdeliveryaddress")
    private String deliveryAddress;
    @Column(name = "userbillingaddress")
    private String billingAddress;
    @JoinColumn(name="userlocality", referencedColumnName = "localityname")
    @ManyToOne
    private LocalityEntity locality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalityEntity getLocality() {
        return locality;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getMail() {
        return mail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLocality(LocalityEntity locality) {
        this.locality = locality;
    }
}