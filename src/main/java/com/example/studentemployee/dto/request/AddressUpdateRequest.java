package com.example.studentemployee.dto.request;
import com.example.studentemployee.enums.PersonType;
public record AddressUpdateRequest(PersonType type, String line1, String line2, String city, String state, String postalCode) {}
