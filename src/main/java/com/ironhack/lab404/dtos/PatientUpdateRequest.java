package com.ironhack.lab404.dtos;

import java.time.LocalDate;

// 5. Actualizar la información del paciente
public class PatientUpdateRequest {
    private String patientName;

    private LocalDate dateOfBirth;

    private Integer admittedBy;

    public PatientUpdateRequest() {
    }

    public PatientUpdateRequest(String patientName, LocalDate dateOfBirth, Integer admittedBy) {
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

    public Integer getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Integer admittedBy) {
        this.admittedBy = admittedBy;
    }
}
