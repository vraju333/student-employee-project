package com.example.studentemployee.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String line1;
    private String line2;
    private String line3;
    private String city; private String state; private String postalCode;
    public String getLine1(){return line1;} public void setLine1(String v){line1=v;}
    public String getLine2(){return line2;} public void setLine2(String v){line2=v;}
    public String getCity(){return city;} public void setCity(String v){city=v;}
    public String getState(){return state;} public void setState(String v){state=v;}
    public String getPostalCode(){return postalCode;} public void setPostalCode(String v){postalCode=v;}
}
