package org.alvarowau.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.alvarowau.hospital.model.dto.request.patient.PatientRequest;
import org.alvarowau.hospital.model.dto.request.patient.PatientUpdateRequest;
import org.alvarowau.hospital.model.dto.response.patient.PatientPublicResponse;
import org.alvarowau.hospital.model.dto.response.patient.PatientResponse;
import org.alvarowau.hospital.service.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;

    @PostMapping
    public ResponseEntity<PatientPublicResponse> createPatient(@RequestBody PatientRequest request) {
        PatientPublicResponse response = patientService.createPatient(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id) {
        PatientResponse response = patientService.getPatientById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PatientPublicResponse>> getAllPatients() {
        List<PatientPublicResponse> response = patientService.getAllPatients();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientPublicResponse> updatePatient(@PathVariable Long id, @RequestBody PatientUpdateRequest request) {
        PatientPublicResponse response = patientService.updatePatient(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
