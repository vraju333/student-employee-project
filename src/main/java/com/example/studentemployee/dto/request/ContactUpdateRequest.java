package com.example.studentemployee.dto.request;
import com.example.studentemployee.enums.PersonType;
public record ContactUpdateRequest(PersonType type, String primaryContact, String secondaryContact) {}
