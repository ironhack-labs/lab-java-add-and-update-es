package com.hospital.management.hospitalmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    private int patientId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", nullable = false)
    @NotNull(message = "Admitted by is required")
    private Employee admittedBy;

    public Patient(int i, String jaimeJordan, LocalDate of, Employee emp2) {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
}


