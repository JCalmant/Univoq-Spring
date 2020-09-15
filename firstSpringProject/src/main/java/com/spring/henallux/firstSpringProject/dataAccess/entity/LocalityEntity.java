package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locality")
public class LocalityEntity {
    @Id
    @Column(name="localityname")
    private String name;
    @Column(name="pocode")
    private Integer pocode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPocode() {
        return pocode;
    }

    public void setPocode(Integer pocode) {
        this.pocode = pocode;
    }

    public LocalityEntity() {}

    public LocalityEntity(String name, Integer pocode) {
        this.name = name;
        this.pocode = pocode;
    }
}