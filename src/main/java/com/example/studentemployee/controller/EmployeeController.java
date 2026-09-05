package com.example.studentemployee.controller;

import com.example.studentemployee.controller.api.EmployeeApi;
import com.example.studentemployee.dto.EmployeeRequest;
import com.example.studentemployee.entity.Employee;
import com.example.studentemployee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements EmployeeApi {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() { return employeeService.getEmployees(); }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) { return employeeService.getEmployee(id); }

    @Override
    public Employee create(EmployeeRequest request) { return employeeService.createEmployee(request); }

    @Override
    public Employee updatePartial(Long id, EmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }

    @Override
    public void delete(Long id) { employeeService.deleteEmployee(id); }

    @Override
    public List<Employee> byDepartment(String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
}
