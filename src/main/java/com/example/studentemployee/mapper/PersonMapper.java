package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.person.PersonCreateRequest;
import com.example.studentemployee.dto.person.PersonPatchRequest;
import com.example.studentemployee.dto.person.PersonUpdateRequest;
import com.example.studentemployee.entity.Person;

public abstract class PersonMapper<T extends Person> {
    protected void mapCommonCreate(PersonCreateRequest request, T entity) {
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setContact(request.contact());
        entity.setAge(request.age());
        entity.setAddress(request.address());
    }

    protected void mapCommonUpdate(PersonUpdateRequest request, T entity) {
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setContact(request.contact());
        entity.setAge(request.age());
        entity.setAddress(request.address());
    }

    protected void mapCommonPatch(PersonPatchRequest request, T entity) {
        if (request.name() != null) entity.setName(request.name());
        if (request.email() != null) entity.setEmail(request.email());
        if (request.contact() != null) entity.setContact(request.contact());
        if (request.age() != null) entity.setAge(request.age());
        if (request.address() != null) entity.setAddress(request.address());
    }
}
