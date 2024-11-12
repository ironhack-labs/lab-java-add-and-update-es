package com.hospital.management.hospitalmanagement.controller;

import com.hospital.management.hospitalmanagement.entity.Patient;
import com.hospital.management.hospitalmanagement.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@Validated
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Añadir nuevo paciente
    @PostMapping
    public ResponseEntity<Patient> addNewPatient(@Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addNewPatient(patient));
    }

    // Actualizar información del paciente
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @Valid @RequestBody Patient updatedPatient) {
        return ResponseEntity.ok(patientService.updatePatient(id, updatedPatient));
    }
}

