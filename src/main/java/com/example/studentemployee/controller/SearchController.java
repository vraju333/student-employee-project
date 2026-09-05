package com.example.studentemployee.controller;

import com.example.studentemployee.entity.Employee;
import com.example.studentemployee.entity.Student;
import com.example.studentemployee.repository.EmployeeRepository;
import com.example.studentemployee.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;

    public SearchController(StudentRepository studentRepository, EmployeeRepository employeeRepository) {
        this.studentRepository = studentRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/person")
    public Map<String, Object> findByEmail(@RequestParam String email) {
        Student student = studentRepository.findByEmailIgnoreCase(email).orElse(null);
        if (student != null) return Map.of("type", "STUDENT", "data", student);

        Employee employee = employeeRepository.findByEmailIgnoreCase(email).orElse(null);
        if (employee != null) return Map.of("type", "EMPLOYEE", "data", employee);

        return Map.of("type", "NOT_FOUND");
    }
}
