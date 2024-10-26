package com.example.hospitalDb.controller;

import com.example.hospitalDb.model.Employee;
import com.example.hospitalDb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PatchMapping("/{id}/status")
    public Employee changeStatus(@PathVariable Long id, @RequestParam Employee.Status status) {
        return employeeService.updateStatus(id, status);
    }

    @PatchMapping("/{id}/department")
    public Employee updateDepartment(@PathVariable Long id, @RequestParam String department) {
        return employeeService.updateDepartment(id, department);
    }
}
