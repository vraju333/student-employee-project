package com.example.studentemployee.entity;

import jakarta.persistence.Entity;

@Entity
public class Student extends BasePerson {
    private String studentCode; private String course; private Integer yearOfStudy; private Double gpa;
    public String getStudentCode(){return studentCode;} public void setStudentCode(String v){studentCode=v;}
    public String getCourse(){return course;} public void setCourse(String v){course=v;}
    public Integer getYearOfStudy(){return yearOfStudy;} public void setYearOfStudy(Integer v){yearOfStudy=v;}
    public Double getGpa(){return gpa;} public void setGpa(Double v){gpa=v;}
}
