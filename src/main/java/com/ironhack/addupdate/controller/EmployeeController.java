package com.ironhack.addupdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ironhack.addupdate.model.Employee;
import com.ironhack.addupdate.repository.EmployeeRepository;

/**
 * EmployeeController
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}/status")
    public Employee updateStatus(@PathVariable Long employeeId, @RequestParam String status) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setDepartment(status);
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}/department")
    public Employee updateDepartment(@PathVariable Long employeeId, @RequestParam String department) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

}
