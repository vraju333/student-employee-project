package com.example.studentemployee.dto.request;

import com.example.studentemployee.enums.PersonType;
import jakarta.validation.constraints.NotNull;

public record PersonRequest(
    @NotNull PersonType type, String firstName, String lastName,
    EmailDetailsRequest emailDetails, ContactDetailsRequest contactDetails, AddressRequest address,
    String employeeCode, String department, String designation, Double salary,
    String studentCode, String course, Integer yearOfStudy, Double gpa
) {}
