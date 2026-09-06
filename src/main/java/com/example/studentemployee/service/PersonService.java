package com.example.studentemployee.service;
import com.example.studentemployee.dto.request.*; import com.example.studentemployee.dto.response.PersonResponse; import com.example.studentemployee.enums.PersonType;
public interface PersonService {
 PersonResponse create(PersonRequest r); PersonResponse update(Long id, PersonRequest r); PersonResponse patch(Long id, PersonPatchRequest r); PersonResponse updateEmail(Long id, EmailUpdateRequest r); PersonResponse updateAddress(Long id, AddressUpdateRequest r); PersonResponse updateContact(Long id, ContactUpdateRequest r); PersonResponse get(Long id, PersonType type); void delete(Long id, PersonType type);
}
