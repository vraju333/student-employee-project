package com.example.studentemployee.service;

import com.example.studentemployee.dto.StudentRequest;
import com.example.studentemployee.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentRequest request);
    Student getStudent(Long id);
    List<Student> getStudents();
    List<Student> getStudentsByCourse(String course);
    Student updateStudent(Long id, StudentRequest request);
    void deleteStudent(Long id);
}
