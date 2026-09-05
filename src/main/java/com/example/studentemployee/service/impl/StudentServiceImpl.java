package com.example.studentemployee.service.impl;

import com.example.studentemployee.dto.StudentRequest;
import com.example.studentemployee.entity.Student;
import com.example.studentemployee.exception.ResourceNotFoundException;
import com.example.studentemployee.repository.StudentRepository;
import com.example.studentemployee.service.StudentService;
import com.example.studentemployee.service.base.AbstractPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends AbstractPersonService<Student, StudentRequest> implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentRequest request) { return create(request); }

    @Override
    public Student getStudent(Long id) { return getById(id); }

    @Override
    public List<Student> getStudents() { return getAll(); }

    @Override
    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourseIgnoreCase(normalize(course));
    }

    @Override
    public Student updateStudent(Long id, StudentRequest request) { return update(id, request); }

    @Override
    public void deleteStudent(Long id) { delete(id); }

    @Override
    public Student create(StudentRequest request) {
        Student student = new Student();
        apply(student, request);
        return studentRepository.save(student);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + id));
    }

    @Override
    public List<Student> getAll() { return studentRepository.findAll(); }

    @Override
    public Student update(Long id, StudentRequest request) {
        Student student = getById(id);
        apply(student, request);
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(getById(id));
    }

    private void apply(Student student, StudentRequest request) {
        student.setName(normalize(request.name()));
        student.setEmail(normalize(request.email()));
        student.setAge(request.age());
        student.setCourse(normalize(request.course()));
        student.setYearOfStudy(request.yearOfStudy());
        student.setGpa(request.gpa());
    }
}
