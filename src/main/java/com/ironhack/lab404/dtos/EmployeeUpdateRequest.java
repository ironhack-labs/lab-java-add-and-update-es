package com.ironhack.lab404.dtos;

import jakarta.validation.constraints.NotNull;

// 3. Cambiar el estado del doctor
// 4. Actualizar el departamento del doctor
public class EmployeeUpdateRequest {

    private  String department;

    private String employeeName;

    private String status;

    public EmployeeUpdateRequest() {
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
