package com.example.demo.services;

import com.example.demo.DTO.CreatePatientRequest;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(CreatePatientRequest patientDTO) {

        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setAdmittedBy(patientDTO.getAdmittedBy());

        return patientRepository.save(patient);
    }
}
