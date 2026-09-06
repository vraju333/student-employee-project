package com.example.studentemployee.service.impl;

import com.example.studentemployee.dto.request.*;
import com.example.studentemployee.dto.response.PersonResponse;
import com.example.studentemployee.entity.*;
import com.example.studentemployee.enums.PersonType;
import com.example.studentemployee.exception.PersonNotFoundException;
import com.example.studentemployee.mapper.*;
import com.example.studentemployee.repository.EmployeeRepository;
import com.example.studentemployee.service.EmployeeService;
import com.example.studentemployee.service.base.AbstractPersonService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends AbstractPersonService<Employee> implements EmployeeService {
    private final EmployeeRepository repo;
    private final EmployeeMapper mapper;
    private final EmailDetailsMapper emailMapper;
    private final AddressMapper addressMapper;
    private final ContactDetailsMapper contactMapper;

    public EmployeeServiceImpl(EmployeeRepository r, EmployeeMapper m, EmailDetailsMapper e, AddressMapper a, ContactDetailsMapper c) {
        repo = r;
        mapper = m;
        emailMapper = e;
        addressMapper = a;
        contactMapper = c;
    }

    protected Employee findEntity(Long id) {
        return repo.findById(id).orElseThrow(() -> new PersonNotFoundException("Employee not found: " + id));
    }

    public PersonResponse create(PersonRequest r) {
        return mapper.toResponse(repo.save(mapper.toEntity(r)));
    }

    public PersonResponse update(Long id, PersonRequest r) {
        Employee e = findEntity(id);
        mapper.update(r, e);
        return mapper.toResponse(repo.save(e));
    }

    public PersonResponse patch(Long id, PersonPatchRequest r) {
        Employee e = findEntity(id);
        if (r.department() != null) e.setDepartment(r.department());
        if (r.designation() != null) e.setDesignation(r.designation());
        if (r.salary() != null) e.setSalary(r.salary());
        return mapper.toResponse(repo.save(e));
    }

    public PersonResponse updateEmail(Long id, EmailUpdateRequest r) {
        Employee e = findEntity(id);
        EmailDetails d = e.getEmailDetails() == null ? new EmailDetails() : e.getEmailDetails();
        emailMapper.apply(new EmailDetailsRequest(r.primaryEmail(), r.secondaryEmail()), d);
        e.setEmailDetails(d);
        return mapper.toResponse(repo.save(e));
    }

    public PersonResponse updateAddress(Long id, AddressUpdateRequest r) {
        Employee e = findEntity(id);
        Address a = e.getAddress() == null ? new Address() : e.getAddress();
        addressMapper.apply(new AddressRequest(r.line1(), r.line2(), r.city(), r.state(), r.postalCode()), a);
        e.setAddress(a);
        return mapper.toResponse(repo.save(e));
    }

    public PersonResponse updateContact(Long id, ContactUpdateRequest r) {
        Employee e = findEntity(id);
        ContactDetails c = e.getContactDetails() == null ? new ContactDetails() : e.getContactDetails();
        contactMapper.apply(new ContactDetailsRequest(r.primaryContact(), r.secondaryContact()), c);
        e.setContactDetails(c);
        return mapper.toResponse(repo.save(e));
    }

    public PersonResponse get(Long id) {
        return mapper.toResponse(findEntity(id));
    }

    public void delete(Long id) {
        repo.delete(findEntity(id));
    }
}
