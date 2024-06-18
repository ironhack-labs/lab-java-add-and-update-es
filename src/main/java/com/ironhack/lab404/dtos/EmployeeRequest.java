package com.ironhack.lab404.dtos;

import jakarta.validation.constraints.NotNull;


// 1. Añadir un nuevo paciente
// 2. Añadir un nuevo doctor
public class EmployeeRequest {

    @NotNull(message = "Employee id is mandatory")
    private Integer employeeId;

    public EmployeeRequest() {
    }

    public EmployeeRequest(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
