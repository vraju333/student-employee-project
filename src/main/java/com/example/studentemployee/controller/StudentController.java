package com.example.studentemployee.controller;

import com.example.studentemployee.controller.api.StudentApi;
import com.example.studentemployee.controller.base.BaseReadController;
import com.example.studentemployee.dto.StudentRequest;
import com.example.studentemployee.entity.Student;
import com.example.studentemployee.service.StudentService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController implements StudentApi, BaseReadController<Student> {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Student create(StudentRequest request) { return studentService.createStudent(request); }
    @Override
    public Student update(Long id, StudentRequest request) { return studentService.updateStudent(id, request); }
    @Override
    public void delete(Long id) { studentService.deleteStudent(id); }
    @Override
    public List<Student> byCourse(String course) { return studentService.getStudentsByCourse(course); }
    @Override
    public List<Student> findAll() { return studentService.getStudents(); }
    @Override
    public Student findById(Long id) { return studentService.getStudent(id); }
}
