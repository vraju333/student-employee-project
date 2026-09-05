package com.example.studentemployee.dto.person;

import com.example.studentemployee.enums.PersonType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmailUpdateRequest(@NotNull PersonType type, @Email @NotBlank String email) {}
