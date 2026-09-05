package com.example.studentemployee.controller.api;

import com.example.studentemployee.dto.EmployeeRequest;
import com.example.studentemployee.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employees")
public interface EmployeeApi {
    @PostMapping
    Employee create(@Valid @RequestBody EmployeeRequest request);

    @PatchMapping("/{id}")
    Employee updatePartial(@PathVariable Long id, @RequestBody EmployeeRequest request);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

    @GetMapping("/department/{department}")
    List<Employee> byDepartment(@PathVariable String department);
}
