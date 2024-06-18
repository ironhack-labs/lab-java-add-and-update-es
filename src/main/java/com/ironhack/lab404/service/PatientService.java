package com.ironhack.lab404.service;


import com.ironhack.lab404.dtos.PatientRequest;
import com.ironhack.lab404.model.Employee;
import com.ironhack.lab404.model.Patient;
import com.ironhack.lab404.repository.EmployeeRepository;
import com.ironhack.lab404.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer patientId){
        return patientRepository.findById(patientId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found."));
    }

    public List<Patient> getByDateOfBirthBetween(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = patientRepository.findByDateOfBirthBetween(startDate, endDate);
        if (patients.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No patients found for this range of Date of birth.");
        }
        return patients;
    }

    public List<Patient> getByAdmittedBy_Department(String department){
        List<Patient> patients = patientRepository.findByAdmittedBy_Department(department);
        if (patients.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No patients found that have been admitted by this department.");
        }
        return patients;
    }

    public List<Patient> getByAdmittedBy_Status(String status){
        List<Patient> patients= patientRepository.findByAdmittedBy_Status(status);
        if (patients.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No patients found their doctor is in this status.");
        }
        return patients;
    }

    // 1. Añadir un nuevo paciente
    public Patient createPatient(PatientRequest receivedPatient){

        Patient newPatient  = new Patient();
        newPatient.setPatientName(receivedPatient.getPatientName());
        newPatient.setDateOfBirth(receivedPatient.getDateOfBirth());

        Integer employeeId = receivedPatient.getAdmittedBy().getEmployeeId();
        Employee admittedBy = employeeRepository.findByEmployeeId(employeeId);

        newPatient.setAdmittedBy(admittedBy);

        return patientRepository.save(newPatient);
    }

}
