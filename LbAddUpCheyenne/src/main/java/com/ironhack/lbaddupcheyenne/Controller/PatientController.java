package com.ironhack.lbaddupcheyenne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ironhack.lbaddupcheyenne.model.Patient;
import com.ironhack.lbaddupcheyenne.repository.PatientRepository;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public ResponseEntity<Patient> addNewPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatientInfo(
            @PathVariable Long patientId,
            @RequestBody Patient updatedPatient
    ) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(updatedPatient.getName());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        patient.setAdmittedBy(updatedPatient.getAdmittedBy());


        Patient updatedPatientEntity = patientRepository.save(patient);
        return new ResponseEntity<>(updatedPatientEntity, HttpStatus.OK);
    }
}
