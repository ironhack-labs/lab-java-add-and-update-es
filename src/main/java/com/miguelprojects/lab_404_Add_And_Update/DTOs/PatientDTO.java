package com.miguelprojects.lab_404_Add_And_Update.DTOs;

import com.miguelprojects.lab_404_Add_And_Update.model.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class PatientDTO {

    private String name;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    private Long admittedBy;

    public PatientDTO() {    }

    public PatientDTO(String name, LocalDate dateOfBirth, Long admittedBy) {
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

    public Long getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Long admittedBy) {
        this.admittedBy = admittedBy;
    }
}
