package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.request.ContactDetailsRequest;
import com.example.studentemployee.dto.response.ContactDetailsResponse;
import com.example.studentemployee.entity.ContactDetails;
import org.springframework.stereotype.Component;

@Component
public class ContactDetailsMapper {
    public ContactDetails toEntity(ContactDetailsRequest r){ if(r==null)return null; ContactDetails c=new ContactDetails(); apply(r,c); return c; }
    public void apply(ContactDetailsRequest r, ContactDetails c){ if(r==null)return; c.setPrimaryContact(r.primaryContact()); c.setSecondaryContact(r.secondaryContact()); }
    public ContactDetailsResponse toResponse(ContactDetails c){ return c==null?null:new ContactDetailsResponse(c.getPrimaryContact(),c.getSecondaryContact()); }
}
