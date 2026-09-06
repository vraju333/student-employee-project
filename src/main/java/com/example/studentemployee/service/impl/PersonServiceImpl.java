package com.example.studentemployee.service.impl;

import com.example.studentemployee.dto.request.*; import com.example.studentemployee.dto.response.PersonResponse; import com.example.studentemployee.enums.PersonType; import com.example.studentemployee.service.*; import com.example.studentemployee.validator.PersonRequestValidator; import org.springframework.stereotype.Service;
@Service public class PersonServiceImpl implements PersonService {
 private final EmployeeService employeeService; private final StudentService studentService; private final PersonRequestValidator validator;
 public PersonServiceImpl(EmployeeService e,StudentService s,PersonRequestValidator v){employeeService=e;studentService=s;validator=v;}
 public PersonResponse create(PersonRequest r){validator.validate(r);return r.type()==PersonType.EMPLOYEE?employeeService.create(r):studentService.create(r);}
 public PersonResponse update(Long id,PersonRequest r){validator.validate(r);return r.type()==PersonType.EMPLOYEE?employeeService.update(id,r):studentService.update(id,r);}
 public PersonResponse patch(Long id,PersonPatchRequest r){return r.type()==PersonType.EMPLOYEE?employeeService.patch(id,r):studentService.patch(id,r);}
 public PersonResponse updateEmail(Long id,EmailUpdateRequest r){return r.type()==PersonType.EMPLOYEE?employeeService.updateEmail(id,r):studentService.updateEmail(id,r);}
 public PersonResponse updateAddress(Long id,AddressUpdateRequest r){return r.type()==PersonType.EMPLOYEE?employeeService.updateAddress(id,r):studentService.updateAddress(id,r);}
 public PersonResponse updateContact(Long id,ContactUpdateRequest r){return r.type()==PersonType.EMPLOYEE?employeeService.updateContact(id,r):studentService.updateContact(id,r);}
 public PersonResponse get(Long id,PersonType type){return type==PersonType.EMPLOYEE?employeeService.get(id):studentService.get(id);}
 public void delete(Long id,PersonType type){if(type==PersonType.EMPLOYEE)employeeService.delete(id);else studentService.delete(id);}
}
