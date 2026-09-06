package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.request.PersonRequest;
import com.example.studentemployee.dto.response.PersonResponse;
import com.example.studentemployee.entity.Employee;
import com.example.studentemployee.enums.PersonType;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper extends AbstractPersonMapper<Employee> {
    public EmployeeMapper(EmailDetailsMapper e, ContactDetailsMapper c, AddressMapper a){super(e,c,a);}
    public Employee toEntity(PersonRequest r){Employee e=new Employee();mapCommon(r,e);applyEmployee(r,e);return e;}
    public void update(PersonRequest r,Employee e){mapCommon(r,e);applyEmployee(r,e);}
    private void applyEmployee(PersonRequest r,Employee e){e.setEmployeeCode(r.employeeCode());e.setDepartment(r.department());e.setDesignation(r.designation());e.setSalary(r.salary());}
    public PersonResponse toResponse(Employee e){return new PersonResponse(e.getId(),PersonType.EMPLOYEE,e.getFirstName(),e.getLastName(),emailMapper.toResponse(e.getEmailDetails()),contactMapper.toResponse(e.getContactDetails()),addressMapper.toResponse(e.getAddress()),e.getEmployeeCode(),e.getDepartment(),e.getDesignation(),e.getSalary(),null,null,null,null);}
}
