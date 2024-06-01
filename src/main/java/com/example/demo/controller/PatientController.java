package com.example.demo.controller;

import com.example.demo.DTO.CreatePatientRequest;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;
    private PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Agregar nuevo paciente
    @PostMapping
    public Patient createPatient(@RequestBody CreatePatientRequest patientDTO) {
        return patientService.createPatient(patientDTO);
    }

    @PatchMapping("/{patientId}")
    public void updatePatient(@PathVariable int patientId, @RequestBody Patient patient) {
        Patient existingPatient = patientRepository.findById(patientId).orElseThrow();
        patientRepository.save(existingPatient);
    }
}
