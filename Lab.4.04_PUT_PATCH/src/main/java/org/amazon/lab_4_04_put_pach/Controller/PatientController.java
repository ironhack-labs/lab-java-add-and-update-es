package org.amazon.lab_4_04_put_pach.Controller;


import org.amazon.lab_4_04_put_pach.DTO.PatientAnsewerDTO;
import org.amazon.lab_4_04_put_pach.DTO.PatientRequestDTO;
import org.amazon.lab_4_04_put_pach.Model.Employee;
import org.amazon.lab_4_04_put_pach.Model.Patient;
import org.amazon.lab_4_04_put_pach.Repository.PatientRepository;
import org.amazon.lab_4_04_put_pach.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientAnsewerDTO> createPatient(@RequestBody PatientRequestDTO patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createAPatient(patient));
    }






}
