package com.example.studentemployee.handler;

import com.example.studentemployee.dto.person.*;
import com.example.studentemployee.entity.Student;
import com.example.studentemployee.exception.ResourceNotFoundException;
import com.example.studentemployee.mapper.StudentMapper;
import com.example.studentemployee.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandHandler {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentCommandHandler(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PersonResponse create(PersonCreateRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public PersonResponse update(Long id, PersonUpdateRequest request) {
        Student student = find(id);
        mapper.updateEntity(request, student);
        return mapper.toResponse(repository.save(student));
    }

    public PersonResponse patch(Long id, PersonPatchRequest request) {
        Student student = find(id);
        mapper.patchEntity(request, student);
        return mapper.toResponse(repository.save(student));
    }

    public PersonResponse updateEmail(Long id, String email) {
        Student student = find(id);
        student.setEmail(email);
        return mapper.toResponse(repository.save(student));
    }

    public PersonResponse updateContact(Long id, String contact) {
        Student student = find(id);
        student.setContact(contact);
        return mapper.toResponse(repository.save(student));
    }

    public PersonResponse get(Long id) { return mapper.toResponse(find(id)); }
    public void delete(Long id) { repository.delete(find(id)); }

    private Student find(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));
    }
}
