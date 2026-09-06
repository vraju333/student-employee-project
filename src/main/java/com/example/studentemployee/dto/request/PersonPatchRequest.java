package com.example.studentemployee.dto.request;

import com.example.studentemployee.enums.PersonType;
import jakarta.validation.constraints.NotNull;

public record PersonPatchRequest(
    @NotNull PersonType type, String firstName, String lastName,
    EmailDetailsRequest emailDetails, ContactDetailsRequest contactDetails, AddressRequest address,
    String department, String designation, Double salary,
    String course, Integer yearOfStudy, Double gpa
) {}
