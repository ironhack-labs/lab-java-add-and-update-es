package com.hospital.management.hospitalmanagement.controller;

import com.hospital.management.hospitalmanagement.entity.Employee;
import com.hospital.management.hospitalmanagement.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // Añadir nuevo doctor
    @PostMapping
    public ResponseEntity<Employee> addNewDoctor(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addNewDoctor(employee));
    }

    // Cambiar el estado del doctor
    @PatchMapping("/{id}/status")
    public ResponseEntity<Employee> updateDoctorStatus(@PathVariable int id, @RequestParam @NotNull Employee.Status status) {
        return ResponseEntity.ok(employeeService.updateDoctorStatus(id, status));
    }

    // Actualizar el departamento del doctor
    @PatchMapping("/{id}/department")
    public ResponseEntity<Employee> updateDoctorDepartment(@PathVariable int id, @RequestParam @NotNull String department) {
        return ResponseEntity.ok(employeeService.updateDoctorDepartment(id, department));
    }
}
