package com.example.studentemployee.controller.api;

import com.example.studentemployee.dto.StudentRequest;
import com.example.studentemployee.entity.Student;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
public interface StudentApi {
    @PostMapping
    Student create(@Valid @RequestBody StudentRequest request);

    @PutMapping("/{id}")
    Student update(@PathVariable Long id, @Valid @RequestBody StudentRequest request);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

    @GetMapping("/course/{course}")
    List<Student> byCourse(@PathVariable String course);
}
