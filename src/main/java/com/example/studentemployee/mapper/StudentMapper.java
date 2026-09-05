package com.example.studentemployee.mapper;

import com.example.studentemployee.dto.person.*;
import com.example.studentemployee.entity.Student;
import com.example.studentemployee.enums.PersonType;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper extends PersonMapper<Student> {
    public Student toEntity(PersonCreateRequest request) {
        Student student = new Student();
        mapCommonCreate(request, student);
        student.setStudentNumber(request.studentNumber());
        student.setCourse(request.course());
        student.setYearOfStudy(request.yearOfStudy());
        student.setGpa(request.gpa());
        student.setGuardianName(request.guardianName());
        return student;
    }

    public void updateEntity(PersonUpdateRequest request, Student student) {
        mapCommonUpdate(request, student);
        student.setStudentNumber(request.studentNumber());
        student.setCourse(request.course());
        student.setYearOfStudy(request.yearOfStudy());
        student.setGpa(request.gpa());
        student.setGuardianName(request.guardianName());
    }

    public void patchEntity(PersonPatchRequest request, Student student) {
        mapCommonPatch(request, student);
        if (request.course() != null) student.setCourse(request.course());
        if (request.yearOfStudy() != null) student.setYearOfStudy(request.yearOfStudy());
        if (request.gpa() != null) student.setGpa(request.gpa());
        if (request.guardianName() != null) student.setGuardianName(request.guardianName());
    }

    public PersonResponse toResponse(Student s) {
        return new PersonResponse(s.getId(), PersonType.STUDENT, s.getName(), s.getEmail(), s.getContact(), s.getAge(), s.getAddress(),
                s.getStudentNumber(), s.getCourse(), s.getYearOfStudy(), s.getGpa(), s.getGuardianName(), null, null, null, null);
    }
}
