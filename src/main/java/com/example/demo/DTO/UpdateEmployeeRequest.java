package com.example.demo.DTO;

import com.example.demo.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class UpdateEmployeeRequest {
    @Column(name = "employee_id")
    private int id;

    @NotBlank
    private String name;

    private String department;

    @Enumerated(EnumType.STRING)
    private Status status;

    public UpdateEmployeeRequest() {
    }

    public UpdateEmployeeRequest(int id, String department, String name, Status status) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateEmployeeRequest that = (UpdateEmployeeRequest) o;
        return id == that.id && Objects.equals(department, that.department) && Objects.equals(name, that.name) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, name, status);
    }
}
