package org.ironhack.lab4_04.service;

import jakarta.persistence.EntityNotFoundException;
import org.ironhack.lab4_04.model.Employee;
import org.ironhack.lab4_04.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void updateStatus(Long employeeId, String status){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    public void updateDepartment(Long employeeId, String department){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }
}
