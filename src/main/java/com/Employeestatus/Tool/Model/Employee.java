package com.Employeestatus.Tool.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employeestatus")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Empid;

    @Column(name = "DOB", nullable = false)
    private LocalDate DOB;

    @Column(name = "Email", nullable = false)
    private String Email;

    @Column(name = "EmpAge", nullable = false)
    private int EmpAge;

    @Column(name = "EmpName", nullable = false)
    private String EmpName;

    @Column(name = "Salary", nullable = false)
    private Double Salary;

    @Column(name = "Status", nullable = false)
    private String status; 

    public Employee() {}

    public Employee(LocalDate DOB,String Email, int EmpAge,  String EmpName, Double Salary, String status) { // Changed from Status to status
    	this.DOB = DOB;
    	this.Email = Email;
    	this.EmpAge = EmpAge;
    	this.EmpName = EmpName;
        this.Salary = Salary;
        this.status = status; 
    }

    public Long getEmpid() {
        return Empid;
    }

    public void setEmpid(Long empid) {
        this.Empid = empid;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        this.EmpName = empName;
    }

    public int getEmpAge() {
        return EmpAge;
    }

    public void setEmpAge(int empAge) {
        this.EmpAge = empAge;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        this.Salary = salary;
    }

    public String getStatus() { 
        return status; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
}
