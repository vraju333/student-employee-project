package com.example.studentemployee.entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BasePerson {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String firstName; private String lastName;
    @Embedded private EmailDetails emailDetails;
    @Embedded private ContactDetails contactDetails;
    @Embedded private Address address;
    public Long getId(){return id;} public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
    public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
    public EmailDetails getEmailDetails(){return emailDetails;} public void setEmailDetails(EmailDetails v){emailDetails=v;}
    public ContactDetails getContactDetails(){return contactDetails;} public void setContactDetails(ContactDetails v){contactDetails=v;}
    public Address getAddress(){return address;} public void setAddress(Address v){address=v;}
}
