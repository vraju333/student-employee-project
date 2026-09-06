package com.example.studentemployee.entity;

import jakarta.persistence.Entity;

@Entity
public class Employee extends BasePerson {
    private String employeeCode; private String department; private String designation; private Double salary;
    public String getEmployeeCode(){return employeeCode;} public void setEmployeeCode(String v){employeeCode=v;}
    public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
    public String getDesignation(){return designation;} public void setDesignation(String v){designation=v;}
    public Double getSalary(){return salary;} public void setSalary(Double v){salary=v;}
}
