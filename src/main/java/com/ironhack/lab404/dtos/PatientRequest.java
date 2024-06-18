package com.ironhack.lab404.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

// 1. Añadir un nuevo paciente
public class PatientRequest {

    @NotBlank(message = "Name is mandatory")
    private String patientName;

    @NotNull(message = "Date of birth is mandatory")
    private LocalDate dateOfBirth;

    private EmployeeRequest admittedBy;

    public PatientRequest(String patientName, LocalDate dateOfBirth, EmployeeRequest admittedBy) {

        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EmployeeRequest getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(EmployeeRequest admittedBy) {
        this.admittedBy = admittedBy;
    }
}
