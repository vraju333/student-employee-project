package com.example.studentemployee.entity;

import jakarta.persistence.*;

@Embeddable
public class ContactDetails {
    private String primaryContact;
    private String secondaryContact;
    public String getPrimaryContact(){return primaryContact;} public void setPrimaryContact(String v){primaryContact=v;}
    public String getSecondaryContact(){return secondaryContact;} public void setSecondaryContact(String v){secondaryContact=v;}
}
