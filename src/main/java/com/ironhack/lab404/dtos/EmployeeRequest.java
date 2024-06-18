package com.ironhack.lab404.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;


// 1. Añadir un nuevo paciente
// 2. Añadir un nuevo doctor
public class EmployeeRequest {

    @NotNull(message = "Employee id is mandatory")
    private Integer employeeId;

    @NotNull(message = "Department is mandatory")
    private  String department;

    @NotNull(message = "Employee name is mandatory")
    private String employeeName;

    @NotNull(message = "Employee status is mandatory")
    private String status;

    public EmployeeRequest() {
    }

    public EmployeeRequest(Integer employeeId, String department, String employeeName, String status) {
        this.employeeId = employeeId;
        this.department = department;
        this.employeeName = employeeName;
        this.status = status;
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

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
