package com.example.studentemployee.dto.request;
import com.example.studentemployee.enums.PersonType;
public record EmailUpdateRequest(PersonType type, String primaryEmail, String secondaryEmail) {}
