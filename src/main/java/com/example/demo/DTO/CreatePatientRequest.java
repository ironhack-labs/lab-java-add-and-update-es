package com.example.demo.DTO;

import com.example.demo.model.Employee;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDate;
import java.util.Objects;

public class CreatePatientRequest {

    @NotBlank
    private String name;
    private LocalDate dateOfBirth;
    private Employee admittedBy;

    public CreatePatientRequest() {}

    public CreatePatientRequest(String name, LocalDate dateOfBirth, Employee admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePatientRequest that = (CreatePatientRequest) o;
        return admittedBy == that.admittedBy && Objects.equals(name, that.name) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, admittedBy);
    }
}
