package com.example.studentemployee.dto.response;

import com.example.studentemployee.enums.PersonType;

public record PersonResponse(
    Long id, PersonType type, String firstName, String lastName,
    EmailDetailsResponse emailDetails, ContactDetailsResponse contactDetails, AddressResponse address,
    String employeeCode, String department, String designation, Double salary,
    String studentCode, String course, Integer yearOfStudy, Double gpa
) {}
