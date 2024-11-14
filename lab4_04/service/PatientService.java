package org.ironhack.lab4_04.service;

import jakarta.persistence.EntityNotFoundException;
import org.ironhack.lab4_04.model.Patient;
import org.ironhack.lab4_04.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

    @Autowired
    public PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Long patientId, Patient updatePatient){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        BeanUtils.copyProperties(updatePatient, patient, "patientId");
        return patientRepository.save(patient);
    }
}
