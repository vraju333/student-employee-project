package com.example.studentemployee.service;

import com.example.studentemployee.dto.person.*;
import com.example.studentemployee.enums.PersonType;

public interface PersonManagementService {
    PersonResponse create(PersonCreateRequest request);
    PersonResponse update(Long id, PersonUpdateRequest request);
    PersonResponse patch(Long id, PersonPatchRequest request);
    PersonResponse updateEmail(Long id, EmailUpdateRequest request);
    PersonResponse updateContact(Long id, ContactUpdateRequest request);
    PersonResponse get(Long id, PersonType type);
    void delete(Long id, PersonType type);
}
