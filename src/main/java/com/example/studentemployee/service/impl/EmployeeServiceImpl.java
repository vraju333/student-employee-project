package com.example.studentemployee.service.impl;

import com.example.studentemployee.dto.EmployeeRequest;
import com.example.studentemployee.entity.Employee;
import com.example.studentemployee.exception.ResourceNotFoundException;
import com.example.studentemployee.repository.EmployeeRepository;
import com.example.studentemployee.service.EmployeeService;
import com.example.studentemployee.service.base.AbstractPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends AbstractPersonService<Employee, EmployeeRequest> implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(EmployeeRequest request) { return create(request); }
    @Override
    public Employee getEmployee(Long id) { return getById(id); }
    @Override
    public List<Employee> getEmployees() { return getAll(); }
    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartmentIgnoreCase(normalize(department));
    }
    @Override
    public Employee updateEmployee(Long id, EmployeeRequest request) { return update(id, request); }
    @Override
    public void deleteEmployee(Long id) { delete(id); }

    @Override
    public Employee create(EmployeeRequest request) {
        Employee employee = new Employee();
        apply(employee, request);
        return employeeRepository.save(employee);
    }
    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
    }
    @Override
    public List<Employee> getAll() { return employeeRepository.findAll(); }
    @Override
    public Employee update(Long id, EmployeeRequest request) {
        Employee employee = getById(id);
        apply(employee, request);
        return employeeRepository.save(employee);
    }
    @Override
    public void delete(Long id) { employeeRepository.delete(getById(id)); }

    private void apply(Employee employee, EmployeeRequest request) {
        employee.setName(normalize(request.name()));
        employee.setEmail(normalize(request.email()));
        employee.setAge(request.age());
        employee.setDepartment(normalize(request.department()));
        employee.setDesignation(normalize(request.designation()));
        employee.setSalary(request.salary());
    }
}
