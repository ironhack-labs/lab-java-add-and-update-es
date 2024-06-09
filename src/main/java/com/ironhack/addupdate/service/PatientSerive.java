package com.ironhack.addupdate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironhack.addupdate.model.Patient;
import com.ironhack.addupdate.repository.PatientRepository;

/**
 * PatientSerive
 */
@Service
public class PatientSerive {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long patientId, Patient patientDetails) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setName(patientDetails.getName());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setAdmittedBy(patientDetails.getAdmittedBy());
        return patientRepository.save(patient);

    }

    public Optional<Patient> getPatientById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}
