package com.ironhack.Lab404.service;

import com.ironhack.Lab404.dtos.PatientDTO;
import com.ironhack.Lab404.model.Employee;
import com.ironhack.Lab404.model.Patient;
import com.ironhack.Lab404.repository.EmployeeRepository;
import com.ironhack.Lab404.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Patient addPatient(PatientDTO patientDTO) {
        Employee admittedBy = employeeRepository.findById(patientDTO.getAdmittedById()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not Found"));

        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setAdmittedBy(admittedBy);
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Integer patientId, PatientDTO patientDTO){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient Not Found"));
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setAdmittedBy(employeeRepository.findById(patientDTO.getAdmittedById()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found")));
        return patientRepository.save(patient);
    }
}
