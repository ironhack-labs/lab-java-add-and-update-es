package com.ironhack.Lab404.repository;

import com.ironhack.Lab404.dtos.PatientDTO;
import com.ironhack.Lab404.model.Patient;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PatientControllerInterface {
    Patient addPatient(@Valid PatientDTO patientDTO);
    Patient updatePatient(Integer patientId, @Valid PatientDTO patientDTO);
}
