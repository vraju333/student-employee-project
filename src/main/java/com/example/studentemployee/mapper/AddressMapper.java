package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.request.AddressRequest;
import com.example.studentemployee.dto.response.AddressResponse;
import com.example.studentemployee.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toEntity(AddressRequest r){ if(r==null)return null; Address a=new Address(); apply(r,a); return a; }
    public void apply(AddressRequest r, Address a){ if(r==null)return; a.setLine1(r.line1());a.setLine2(r.line2());a.setCity(r.city());a.setState(r.state());a.setPostalCode(r.postalCode()); }
    public AddressResponse toResponse(Address a){ return a==null?null:new AddressResponse(a.getLine1(),a.getLine2(),a.getCity(),a.getState(),a.getPostalCode()); }
}
