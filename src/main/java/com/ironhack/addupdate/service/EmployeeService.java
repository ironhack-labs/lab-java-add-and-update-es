package com.ironhack.addupdate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironhack.addupdate.model.Employee;
import com.ironhack.addupdate.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;



    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee updateStatus(Long employeeId, String status) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setStatus(status);
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId);

    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
