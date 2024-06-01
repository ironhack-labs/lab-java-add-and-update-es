package org.ironhack.hospitalapi.controller;

import org.ironhack.hospitalapi.model.Employee;
import org.ironhack.hospitalapi.model.Patient;
import org.ironhack.hospitalapi.repository.EmployeeRepository;
import org.ironhack.hospitalapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(201).body(savedEmployee);
    }

    @PostMapping("/patients")
    public ResponseEntity<?> addPatient(@Valid @RequestBody Patient patient) {
        Optional<Employee> admittedByEmployee = employeeRepository.findById(patient.getAdmittedBy());
        if (!admittedByEmployee.isPresent()) {
            return ResponseEntity.badRequest().body("Admitting doctor does not exist.");
        }
        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.status(201).body(savedPatient);
    }

    @PutMapping("/employees/{id}/status")
    public ResponseEntity<Employee> changeDoctorStatus(@PathVariable Integer id, @RequestBody String status) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setStatus(status);
            Employee updatedEmployee = employeeRepository.save(employee);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/employees/{id}/department")
    public ResponseEntity<Employee> updateDoctorDepartment(@PathVariable Integer id, @RequestBody String department) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setDepartment(department);
            Employee updatedEmployee = employeeRepository.save(employee);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/patients/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Integer id, @RequestBody Patient patientDetails) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            if (patientDetails.getName() != null) patient.setName(patientDetails.getName());
            if (patientDetails.getDateOfBirth() != null) patient.setDateOfBirth(patientDetails.getDateOfBirth());
            if (patientDetails.getAdmittedBy() != null) {
                Optional<Employee> admittedByEmployee = employeeRepository.findById(patientDetails.getAdmittedBy());
                if (admittedByEmployee.isEmpty()) {
                    return ResponseEntity.badRequest().body("Admitting doctor does not exist.");                }
                patient.setAdmittedBy(patientDetails.getAdmittedBy());
            }
            Patient updatedPatient = patientRepository.save(patient);
            return ResponseEntity.badRequest().body("Admitting doctor does not exist.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
