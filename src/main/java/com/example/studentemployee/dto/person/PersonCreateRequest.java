package com.example.studentemployee.dto.person;

import com.example.studentemployee.enums.PersonType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonCreateRequest(
        @NotNull PersonType type,
        @NotBlank String name,
        @Email @NotBlank String email,
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
