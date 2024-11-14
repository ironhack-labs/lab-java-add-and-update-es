package org.ironhack.lab4_04.controller;

import org.ironhack.lab4_04.model.Patient;
import org.ironhack.lab4_04.repository.PatientRepository;
import org.ironhack.lab4_04.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addNewPatient( @RequestBody Patient patient) {
        Patient savedPatient = patientService.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id,
                                                 @RequestBody Patient patient) {
        Patient updatedPatient = patientService.update(id, patient);
        return ResponseEntity.ok(updatedPatient);
    }
}