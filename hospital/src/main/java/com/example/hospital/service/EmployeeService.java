package com.example.hospital.service;

import com.example.hospital.model.Employee;
import com.example.hospital.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Optional getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    public List<Employee> getEmployeesByStatus(String status) {
        return employeeRepository.finfByStatus(status);
    }
    public List<Employee> getEmployeesByDepartment(String department) {
         return employeeRepository.findByDepartment(department);
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long id ,Employee  updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setName(updatedEmployee.getName());
        employee.setStatus(updatedEmployee.getStatus());
        return employeeRepository.save(employee);
    }
    public Employee updateEmployeeStatus(Long id ,String status) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
        employee.setStatus(status);
        return employeeRepository.save(employee);

    }

}
