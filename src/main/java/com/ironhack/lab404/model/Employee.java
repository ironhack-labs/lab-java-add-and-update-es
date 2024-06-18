package com.ironhack.lab404.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "department")
    private String department;

    @Column(name = "name")
    private String employeeName;

    @Column(name = "status")
    private String status;

    @OneToMany (mappedBy = "admittedBy")
    private List<Patient> patients;

    public Employee() {
    }

    public Employee(Integer employeeId, String department, String employeeName, String status, List<Patient> patients) {
        this.employeeId = employeeId;
        this.department = department;
        this.employeeName = employeeName;
        this.status = status;
        this.patients = patients;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String employeeStatus) {
        this.status = employeeStatus;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeId(), employee.getEmployeeId()) && Objects.equals(getDepartment(), employee.getDepartment()) && Objects.equals(getEmployeeName(), employee.getEmployeeName()) && Objects.equals(getStatus(), employee.getStatus()) && Objects.equals(getPatients(), employee.getPatients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getDepartment(), getEmployeeName(), getStatus(), getPatients());
    }
}
