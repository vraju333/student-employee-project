package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.person.*;
import com.example.studentemployee.entity.Employee;
import com.example.studentemployee.enums.PersonType;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper extends PersonMapper<Employee> {
    public Employee toEntity(PersonCreateRequest request) {
        Employee employee = new Employee();
        mapCommonCreate(request, employee);
        employee.setEmployeeNumber(request.employeeNumber());
        employee.setDepartment(request.department());
        employee.setDesignation(request.designation());
        employee.setSalary(request.salary());
        return employee;
    }

    public void updateEntity(PersonUpdateRequest request, Employee employee) {
        mapCommonUpdate(request, employee);
        employee.setEmployeeNumber(request.employeeNumber());
        employee.setDepartment(request.department());
        employee.setDesignation(request.designation());
        employee.setSalary(request.salary());
    }

    public void patchEntity(PersonPatchRequest request, Employee employee) {
        mapCommonPatch(request, employee);
        if (request.department() != null) employee.setDepartment(request.department());
        if (request.designation() != null) employee.setDesignation(request.designation());
        if (request.salary() != null) employee.setSalary(request.salary());
    }

    public PersonResponse toResponse(Employee e) {
        return new PersonResponse(e.getId(), PersonType.EMPLOYEE, e.getName(), e.getEmail(), e.getContact(), e.getAge(), e.getAddress(),
                null, null, null, null, null, e.getEmployeeNumber(), e.getDepartment(), e.getDesignation(), e.getSalary());
    }
}
