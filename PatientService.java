package com.hospital.management.hospitalmanagement.service;

import com.hospital.management.hospitalmanagement.entity.Patient;
import com.hospital.management.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient addNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(int id, Patient updatedPatient) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Actualiza todos los campos del paciente
        patient.setName(updatedPatient.getName());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        patient.setAdmittedBy(updatedPatient.getAdmittedBy());

        return patientRepository.save(patient);
    }
}
