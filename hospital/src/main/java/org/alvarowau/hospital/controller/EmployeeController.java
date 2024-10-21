package org.alvarowau.hospital.controller;

import lombok.RequiredArgsConstructor;
import org.alvarowau.hospital.model.dto.request.employee.EmployeeRequest;
import org.alvarowau.hospital.model.dto.request.employee.EmployeeUpdateRequest;
import org.alvarowau.hospital.model.dto.response.employee.EmployeePublicResponse;
import org.alvarowau.hospital.model.dto.response.employee.EmployeeResponse;
import org.alvarowau.hospital.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeePublicResponse> createEmployee(@RequestBody EmployeeRequest request) {
        EmployeePublicResponse response = employeeService.createEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        EmployeeResponse response = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeePublicResponse>> getAllEmployees() {
        List<EmployeePublicResponse> response = employeeService.getAllEmployees();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeePublicResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateRequest request) {
        EmployeePublicResponse response = employeeService.updateEmployee(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
