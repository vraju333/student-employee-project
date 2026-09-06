package com.example.studentemployee.repository;
import com.example.studentemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee,Long> { boolean existsByEmployeeCode(String employeeCode); }
