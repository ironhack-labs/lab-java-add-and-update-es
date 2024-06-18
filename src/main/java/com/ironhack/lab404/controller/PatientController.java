package com.ironhack.lab404.controller;


import com.ironhack.lab404.dtos.PatientRequest;
import com.ironhack.lab404.dtos.PatientUpdateRequest;
import com.ironhack.lab404.model.Patient;
import com.ironhack.lab404.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping("/patientId/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable Integer patientId){
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/dateOfBirthBetween")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirthBetween(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/admittedBy/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByAdmittedBy_Department(@PathVariable String department){
        return patientService.getByAdmittedBy_Department(department);
    }

    @GetMapping("/doctor/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByAdmittedBy_Status(@PathVariable String status){
        return patientService.getByAdmittedBy_Status(status);
    }

    // 1. Añadir un nuevo paciente
    @PostMapping("/newPatient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@Valid @RequestBody PatientRequest patientRequest){
        return patientService.createPatient(patientRequest);
    }

    // 5. Actualizar la información del paciente
    @PutMapping("/{patientId}/updatePatient")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient (@PathVariable Integer patientId,
                               @RequestBody PatientUpdateRequest patientUpdateRequest){
        patientService.updatePatient(patientId, patientUpdateRequest);

    }

}
