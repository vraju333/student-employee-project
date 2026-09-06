package com.example.studentemployee.repository;
import com.example.studentemployee.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student,Long> { boolean existsByStudentCode(String studentCode); }
