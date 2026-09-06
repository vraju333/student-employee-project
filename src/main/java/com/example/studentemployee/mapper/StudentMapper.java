package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.request.PersonRequest;
import com.example.studentemployee.dto.response.PersonResponse;
import com.example.studentemployee.entity.Student;
import com.example.studentemployee.enums.PersonType;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper extends AbstractPersonMapper<Student> {
    public StudentMapper(EmailDetailsMapper e, ContactDetailsMapper c, AddressMapper a){super(e,c,a);}
    public Student toEntity(PersonRequest r){Student s=new Student();mapCommon(r,s);applyStudent(r,s);return s;}
    public void update(PersonRequest r,Student s){mapCommon(r,s);applyStudent(r,s);}
    private void applyStudent(PersonRequest r,Student s){s.setStudentCode(r.studentCode());s.setCourse(r.course());s.setYearOfStudy(r.yearOfStudy());s.setGpa(r.gpa());}
    public PersonResponse toResponse(Student s){return new PersonResponse(s.getId(),PersonType.STUDENT,s.getFirstName(),s.getLastName(),emailMapper.toResponse(s.getEmailDetails()),contactMapper.toResponse(s.getContactDetails()),addressMapper.toResponse(s.getAddress()),null,null,null,null,s.getStudentCode(),s.getCourse(),s.getYearOfStudy(),s.getGpa());}
}
