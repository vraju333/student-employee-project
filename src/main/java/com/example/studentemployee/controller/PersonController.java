package com.example.studentemployee.controller;

import com.example.studentemployee.dto.request.*; import com.example.studentemployee.dto.response.PersonResponse; import com.example.studentemployee.enums.PersonType; import com.example.studentemployee.service.PersonService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/persons")
public class PersonController {
 private final PersonService service; public PersonController(PersonService s){service=s;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public PersonResponse create(@Valid @RequestBody PersonRequest r){return service.create(r);}
 @PutMapping("/{id}") public PersonResponse update(@PathVariable Long id,@Valid @RequestBody PersonRequest r){return service.update(id,r);}
 @PatchMapping("/{id}") public PersonResponse patch(@PathVariable Long id,@RequestBody PersonPatchRequest r){return service.patch(id,r);}
 @PatchMapping("/{id}/email") public PersonResponse updateEmail(@PathVariable Long id,@RequestBody EmailUpdateRequest r){return service.updateEmail(id,r);}
 @PatchMapping("/{id}/address") public PersonResponse updateAddress(@PathVariable Long id,@RequestBody AddressUpdateRequest r){return service.updateAddress(id,r);}
 @PatchMapping("/{id}/contact") public PersonResponse updateContact(@PathVariable Long id,@RequestBody ContactUpdateRequest r){return service.updateContact(id,r);}
 @GetMapping("/{id}") public PersonResponse get(@PathVariable Long id,@RequestParam PersonType type){return service.get(id,type);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id,@RequestParam PersonType type){service.delete(id,type);}
}
