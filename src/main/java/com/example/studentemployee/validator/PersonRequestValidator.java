package com.example.studentemployee.validator;

import com.example.studentemployee.dto.request.PersonRequest;
import com.example.studentemployee.enums.PersonType;
import com.example.studentemployee.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class PersonRequestValidator {
    public void validate(PersonRequest r) {
        if (r.type() == PersonType.EMPLOYEE && r.employeeCode() == null)
            throw new BadRequestException("employeeCode is required");
        if (r.type() == PersonType.STUDENT && r.studentCode() == null)
            throw new BadRequestException("studentCode is required");
    }
}
