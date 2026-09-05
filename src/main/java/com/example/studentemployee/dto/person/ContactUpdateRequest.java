package com.example.studentemployee.dto.person;

import com.example.studentemployee.enums.PersonType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactUpdateRequest(@NotNull PersonType type, @NotBlank String contact) {}
