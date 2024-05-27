package com.ironhack.Lab404.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Date o birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;

    public Patient(String name, Date dateOfBirth, Employee  admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public Patient() {}

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Employee employee) {
        this.admittedBy = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(patientId, patient.patientId) && Objects.equals(name, patient.name) && Objects.equals(dateOfBirth, patient.dateOfBirth) && Objects.equals(admittedBy, patient.admittedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, name, dateOfBirth, admittedBy);
    }
}
