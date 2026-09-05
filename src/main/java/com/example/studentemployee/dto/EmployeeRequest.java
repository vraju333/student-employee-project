package com.example.studentemployee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeRequest(
        @NotBlank String name,
        @Email @NotBlank String email,
        Integer age,
        @NotBlank String department,
        String designation,
        Double salary
) {}
