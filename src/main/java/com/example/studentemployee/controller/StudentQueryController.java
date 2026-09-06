package com.example.studentemployee.controller;
import com.example.studentemployee.dto.response.PersonResponse; import com.example.studentemployee.service.StudentService; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/students") public class StudentQueryController { private final StudentService service; public StudentQueryController(StudentService s){service=s;} @GetMapping("/{id}") public PersonResponse get(@PathVariable Long id){return service.get(id);} }
