package com.example.studentemployee.repository;

import com.example.studentemployee.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseIgnoreCase(String course);
    Optional<Student> findByEmailIgnoreCase(String email);
}
