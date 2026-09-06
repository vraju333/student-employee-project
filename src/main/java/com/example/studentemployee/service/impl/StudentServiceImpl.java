package com.example.studentemployee.service.impl;

import com.example.studentemployee.dto.request.*;
import com.example.studentemployee.dto.response.PersonResponse;
import com.example.studentemployee.entity.*;
import com.example.studentemployee.exception.PersonNotFoundException;
import com.example.studentemployee.mapper.*;
import com.example.studentemployee.repository.StudentRepository;
import com.example.studentemployee.service.StudentService;
import com.example.studentemployee.service.base.AbstractPersonService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends AbstractPersonService<Student> implements StudentService {
    private final StudentRepository repo;
    private final StudentMapper mapper;
    private final EmailDetailsMapper emailMapper;
    private final AddressMapper addressMapper;
    private final ContactDetailsMapper contactMapper;

    public StudentServiceImpl(StudentRepository r, StudentMapper m, EmailDetailsMapper e, AddressMapper a, ContactDetailsMapper c) {
        repo = r;
        mapper = m;
        emailMapper = e;
        addressMapper = a;
        contactMapper = c;
    }

    protected Student findEntity(Long id) {
        return repo.findById(id).orElseThrow(() -> new PersonNotFoundException("Student not found: " + id));
    }

    public PersonResponse create(PersonRequest r) {
        return mapper.toResponse(repo.save(mapper.toEntity(r)));
    }

    public PersonResponse update(Long id, PersonRequest r) {
        Student s = findEntity(id);
        mapper.update(r, s);
        return mapper.toResponse(repo.save(s));
    }

    public PersonResponse patch(Long id, PersonPatchRequest r) {
        Student s = findEntity(id);
        if (r.course() != null) s.setCourse(r.course());
        if (r.yearOfStudy() != null) s.setYearOfStudy(r.yearOfStudy());
        if (r.gpa() != null) s.setGpa(r.gpa());
        return mapper.toResponse(repo.save(s));
    }

    public PersonResponse updateEmail(Long id, EmailUpdateRequest r) {
        Student s = findEntity(id);
        EmailDetails d = s.getEmailDetails() == null ? new EmailDetails() : s.getEmailDetails();
        emailMapper.apply(new EmailDetailsRequest(r.primaryEmail(), r.secondaryEmail()), d);
        s.setEmailDetails(d);
        return mapper.toResponse(repo.save(s));
    }

    public PersonResponse updateAddress(Long id, AddressUpdateRequest r) {
        Student s = findEntity(id);
        Address a = s.getAddress() == null ? new Address() : s.getAddress();
        addressMapper.apply(new AddressRequest("test", r.line2(), r.city(), r.state(), r.postalCode()), a);
        s.setAddress(a);
        return mapper.toResponse(repo.save(s));
    }

    public PersonResponse updateContact(Long id, ContactUpdateRequest r) {
        Student s = findEntity(id);
        ContactDetails c = s.getContactDetails() == null ? new ContactDetails() : s.getContactDetails();
        contactMapper.apply(new ContactDetailsRequest(r.primaryContact(), r.secondaryContact()), c);
        s.setContactDetails(c);
        return mapper.toResponse(repo.save(s));
    }

    public PersonResponse get(Long id) {
        return mapper.toResponse(findEntity(id));
    }

    public void delete(Long id) {
        repo.delete(findEntity(id));
    }
}
