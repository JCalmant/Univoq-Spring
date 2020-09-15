package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.model.Locality;

public class ConverterStringLocality {
    public static Locality stringLoc(String loc){
        String locality[]=loc.split("/");
        return new Locality(locality[0],Integer.parseInt(locality[1]));
    }
}
