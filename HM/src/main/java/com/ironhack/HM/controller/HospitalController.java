package com.ironhack.HM.controller;

import com.ironhack.HM.model.Employee;
import com.ironhack.HM.model.Patient;
import com.ironhack.HM.repository.EmployeeRepository;
import com.ironhack.HM.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HospitalController {
    private final EmployeeRepository employeeRepository;

    private final PatientRepository patientRepository;

    public HospitalController(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PatchMapping("/employees/{id}/status")
    public Employee updateEmployeeStatus(@PathVariable Long id, @RequestBody Employee.Status status) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setStatus(status);
        return employeeRepository.save(employee);
    }

    @PatchMapping("/employees/{id}/department")
    public Employee updateEmployeeDepartment(@PathVariable Long id, @RequestBody String department) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @PutMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setName(updatedPatient.getName());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        patient.setAdmittedBy(updatedPatient.getAdmittedBy());
        return patientRepository.save(patient);
    }
}
