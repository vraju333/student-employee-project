package com.example.studentemployee.validator;

import com.example.studentemployee.dto.person.PersonCreateRequest;
import com.example.studentemployee.enums.PersonType;
import com.example.studentemployee.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PersonRequestValidator {
    public void validateCreate(PersonCreateRequest request) {
        if (request.type() == PersonType.STUDENT && (request.course() == null || request.studentNumber() == null)) {
            throw new IllegalArgumentException("Student requires studentNumber and course");
        }
        if (request.type() == PersonType.EMPLOYEE && (request.department() == null || request.employeeNumber() == null)) {
            throw new IllegalArgumentException("Employee requires employeeNumber and department");
        }
    }
}
