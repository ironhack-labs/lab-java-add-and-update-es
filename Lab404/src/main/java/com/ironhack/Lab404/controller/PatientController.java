package com.ironhack.Lab404.controller;

import com.ironhack.Lab404.dtos.PatientDTO;
import com.ironhack.Lab404.model.Patient;
import com.ironhack.Lab404.model.Status;
import com.ironhack.Lab404.repository.EmployeeRepository;
import com.ironhack.Lab404.repository.PatientControllerInterface;
import com.ironhack.Lab404.repository.PatientRepository;
import com.ironhack.Lab404.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientController implements PatientControllerInterface {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addPatient(@Valid @RequestBody PatientDTO patientDTO) {
        return patientService.addPatient(patientDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient updatePatient(@PathVariable("id") Integer patientId, @Valid @RequestBody PatientDTO patientDTO) {
        return patientService.updatePatient(patientId, patientDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable(name = "id") Integer patientId) {
        return patientRepository.findById(patientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
    }

    @GetMapping("/dob")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsBetweenDates(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                                 @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittedByDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsWithDoctorOffStatus(@PathVariable String status) {
        return patientRepository.findByAdmittedByStatus(Status.valueOf(status));
    }

}
