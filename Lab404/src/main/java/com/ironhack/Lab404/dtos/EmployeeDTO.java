package com.ironhack.Lab404.dtos;

import com.ironhack.Lab404.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {
    @NotNull(message = "Employee id is mandatory")
    private Integer employeeId;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Status is mandatory")
    @Enumerated(EnumType.STRING)
    private Status status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
