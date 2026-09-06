package com.example.studentemployee.controller;

import com.example.studentemployee.dto.response.PersonResponse;
import com.example.studentemployee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeQueryController {
    private final EmployeeService service;

    public EmployeeQueryController(EmployeeService s) {
        service = s;
    }

    @GetMapping("/{id}")
    public PersonResponse get(@PathVariable Long id) {
        return service.get(id);
    }
}
