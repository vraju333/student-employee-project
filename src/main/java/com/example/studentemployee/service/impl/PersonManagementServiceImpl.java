package com.example.studentemployee.service.impl;

import com.example.studentemployee.dto.person.*;
import com.example.studentemployee.enums.PersonType;
import com.example.studentemployee.handler.EmployeeCommandHandler;
import com.example.studentemployee.handler.StudentCommandHandler;
import com.example.studentemployee.service.PersonManagementService;
import com.example.studentemployee.validator.PersonRequestValidator;
import org.springframework.stereotype.Service;

@Service
public class PersonManagementServiceImpl implements PersonManagementService {
    private final StudentCommandHandler studentHandler;
    private final EmployeeCommandHandler employeeHandler;
    private final PersonRequestValidator validator;

    public PersonManagementServiceImpl(StudentCommandHandler studentHandler,
                                       EmployeeCommandHandler employeeHandler,
                                       PersonRequestValidator validator) {
        this.studentHandler = studentHandler;
        this.employeeHandler = employeeHandler;
        this.validator = validator;
    }

    @Override
    public PersonResponse create(PersonCreateRequest request) {
        validator.validateCreate(request);
        return request.type() == PersonType.STUDENT ? studentHandler.create(request) : employeeHandler.create(request);
    }

    @Override
    public PersonResponse update(Long id, PersonUpdateRequest request) {
        return request.type() == PersonType.STUDENT ? studentHandler.update(id, request) : employeeHandler.update(id, request);
    }

    @Override
    public PersonResponse patch(Long id, PersonPatchRequest request) {
        return request.type() == PersonType.STUDENT ? studentHandler.patch(id, request) : employeeHandler.patch(id, request);
    }

    @Override
    public PersonResponse updateEmail(Long id, EmailUpdateRequest request) {
        return request.type() == PersonType.STUDENT ? studentHandler.updateEmail(id, request.email()) : employeeHandler.updateEmail(id, request.email());
    }

    @Override
    public PersonResponse updateContact(Long id, ContactUpdateRequest request) {
        return request.type() == PersonType.STUDENT ? studentHandler.updateContact(id, request.contact()) : employeeHandler.updateContact(id, request.contact());
    }

    @Override
    public PersonResponse get(Long id, PersonType type) {
        return type == PersonType.STUDENT ? studentHandler.get(id) : employeeHandler.get(id);
    }

    @Override
    public void delete(Long id, PersonType type) {
        if (type == PersonType.STUDENT) studentHandler.delete(id); else employeeHandler.delete(id);
    }
}
