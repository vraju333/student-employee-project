package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.request.PersonRequest;
import com.example.studentemployee.entity.BasePerson;

public abstract class AbstractPersonMapper<T extends BasePerson> {
    protected final EmailDetailsMapper emailMapper; protected final ContactDetailsMapper contactMapper; protected final AddressMapper addressMapper;
    protected AbstractPersonMapper(EmailDetailsMapper e, ContactDetailsMapper c, AddressMapper a){emailMapper=e;contactMapper=c;addressMapper=a;}
    protected void mapCommon(PersonRequest r,T p){ p.setFirstName(r.firstName());p.setLastName(r.lastName());p.setEmailDetails(emailMapper.toEntity(r.emailDetails()));p.setContactDetails(contactMapper.toEntity(r.contactDetails()));p.setAddress(addressMapper.toEntity(r.address())); }
}
