package com.example.studentemployee.handler;

import com.example.studentemployee.dto.person.*;
import com.example.studentemployee.entity.Employee;
import com.example.studentemployee.exception.ResourceNotFoundException;
import com.example.studentemployee.mapper.EmployeeMapper;
import com.example.studentemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCommandHandler {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeCommandHandler(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PersonResponse create(PersonCreateRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public PersonResponse update(Long id, PersonUpdateRequest request) {
        Employee employee = find(id);
        mapper.updateEntity(request, employee);
        return mapper.toResponse(repository.save(employee));
    }

    public PersonResponse patch(Long id, PersonPatchRequest request) {
        Employee employee = find(id);
        mapper.patchEntity(request, employee);
        return mapper.toResponse(repository.save(employee));
    }

    public PersonResponse updateEmail(Long id, String email) {
        Employee employee = find(id);
        employee.setEmail(email);
        return mapper.toResponse(repository.save(employee));
    }

    public PersonResponse updateContact(Long id, String contact) {
        Employee employee = find(id);
        employee.setContact(contact);
        return mapper.toResponse(repository.save(employee));
    }

    public PersonResponse get(Long id) { return mapper.toResponse(find(id)); }
    public void delete(Long id) { repository.delete(find(id)); }

    private Employee find(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
    }
}
