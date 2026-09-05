package com.example.studentemployee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
        @NotBlank String name,
        @Email @NotBlank String email,
        Integer age,
        @NotBlank String course,
        Integer yearOfStudy,
        Double gpa
) {}
