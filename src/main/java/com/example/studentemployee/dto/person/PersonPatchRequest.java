package com.example.studentemployee.dto.person;

import com.example.studentemployee.enums.PersonType;
import jakarta.validation.constraints.NotNull;

public record PersonPatchRequest(
        @NotNull PersonType type,
        String name,
        String email,
        String contact,
        Integer age,
        String address,
        String course,
        Integer yearOfStudy,
        Double gpa,
        String guardianName,
        String department,
        String designation,
        Double salary
) {}
