package com.ironhack.Lab404.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;

public class PatientDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Date o birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotNull(message = "Admitted by employee ID is mandatory")
    private Integer admittedById;

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

    public Integer getAdmittedById() {
        return admittedById;
    }

    public void setAdmittedById(Integer admittedById) {
        this.admittedById = admittedById;
    }
}
