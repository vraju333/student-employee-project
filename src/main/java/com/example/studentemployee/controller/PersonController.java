package com.example.studentemployee.controller;

import com.example.studentemployee.dto.person.*;
import com.example.studentemployee.enums.PersonType;
import com.example.studentemployee.service.PersonManagementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonManagementService personService;

    public PersonController(PersonManagementService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse create(@Valid @RequestBody PersonCreateRequest request) {
        return personService.create(request);
    }

    @PutMapping("/{id}")
    public PersonResponse update(@PathVariable Long id, @Valid @RequestBody PersonUpdateRequest request) {
        return personService.update(id, request);
    }

    @PatchMapping("/{id}")
    public PersonResponse patch(@PathVariable Long id, @Valid @RequestBody PersonPatchRequest request) {
        return personService.patch(id, request);
    }

    @PatchMapping("/{id}/email")
    public PersonResponse updateEmail(@PathVariable Long id, @Valid @RequestBody EmailUpdateRequest request) {
        return personService.updateEmail(id, request);
    }

    @PatchMapping("/{id}/contact")
    public PersonResponse updateContact(@PathVariable Long id, @Valid @RequestBody ContactUpdateRequest request) {
        return personService.updateContact(id, request);
    }

    @GetMapping("/{id}")
    public PersonResponse get(@PathVariable Long id, @RequestParam PersonType type) {
        return personService.get(id, type);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @RequestParam PersonType type) {
        personService.delete(id, type);
    }
}
