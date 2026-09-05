package com.example.studentemployee.service;

import com.example.studentemployee.dto.EmployeeRequest;
import com.example.studentemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeRequest request);
    Employee getEmployee(Long id);
    List<Employee> getEmployees();
    List<Employee> getEmployeesByDepartment(String department);
    Employee updateEmployee(Long id, EmployeeRequest request);
    void deleteEmployee(Long id);
}
