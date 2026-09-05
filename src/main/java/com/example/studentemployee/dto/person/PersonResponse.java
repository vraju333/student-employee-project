package com.example.studentemployee.dto.person;

import com.example.studentemployee.enums.PersonType;

public record PersonResponse(
        Long id,
        PersonType type,
        String name,
        String email,
        String contact,
        Integer age,
        String address,
        String studentNumber,
        String course,
        Integer yearOfStudy,
        Double gpa,
        String guardianName,
        String employeeNumber,
        String department,
        String designation,
        Double salary
) {}
