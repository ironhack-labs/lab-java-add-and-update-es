package com.example.hospitalDb.service;

import com.example.hospitalDb.model.Employee;
import com.example.hospitalDb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateDepartment(Long id, String department) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public Employee updateStatus(Long id, Employee.Status status) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setStatus(status);
        return employeeRepository.save(employee);
    }
}
