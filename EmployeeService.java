package com.hospital.management.hospitalmanagement.service;

import com.hospital.management.hospitalmanagement.entity.Employee;
import com.hospital.management.hospitalmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addNewDoctor(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateDoctorStatus(int id, Employee.Status status) {
        Employee doctor = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.setStatus(status);
        return employeeRepository.save(doctor);
    }

    public Employee updateDoctorDepartment(int id, String department) {
        Employee doctor = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.setDepartment(department);
        return employeeRepository.save(doctor);
    }
}

