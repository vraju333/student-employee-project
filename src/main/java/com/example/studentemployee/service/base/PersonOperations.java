package com.example.studentemployee.service.base;
import com.example.studentemployee.dto.request.*; import com.example.studentemployee.dto.response.PersonResponse;
public interface PersonOperations {
 PersonResponse create(PersonRequest request); PersonResponse update(Long id, PersonRequest request); PersonResponse patch(Long id, PersonPatchRequest request);
 PersonResponse updateEmail(Long id, EmailUpdateRequest request); PersonResponse updateAddress(Long id, AddressUpdateRequest request); PersonResponse updateContact(Long id, ContactUpdateRequest request);
 PersonResponse get(Long id); void delete(Long id);
}
