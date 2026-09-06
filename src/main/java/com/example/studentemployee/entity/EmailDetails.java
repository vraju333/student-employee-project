package com.example.studentemployee.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmailDetails {
    private String primaryEmail; private String secondaryEmail;
    public String getPrimaryEmail(){return primaryEmail;} public void setPrimaryEmail(String v){primaryEmail=v;}
    public String getSecondaryEmail(){return secondaryEmail;} public void setSecondaryEmail(String v){secondaryEmail=v;}
}
