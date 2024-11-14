package org.ironhack.lab4_04.controller;

import org.ironhack.lab4_04.model.Employee;
import org.ironhack.lab4_04.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> changeDoctorStatus(@PathVariable Long id,
                                                   @RequestParam String status){
        employeeService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/department")
    public ResponseEntity<Void> updateDoctorDepartment(@PathVariable Long id,
                                                       @RequestParam String department){
        employeeService.updateDepartment(id, department);
        return ResponseEntity.ok().build();
    }


}
