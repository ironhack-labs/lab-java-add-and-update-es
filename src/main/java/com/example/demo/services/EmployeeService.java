package com.example.demo.services;

import com.example.demo.DTO.CreateEmployeeRequest;
import com.example.demo.DTO.UpdateEmployeeRequest;
import com.example.demo.model.Employee;
import com.example.demo.model.Status;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(CreateEmployeeRequest employeeDTO) {

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setStatus(employeeDTO.getStatus());

        return employeeRepository.save(employee);
    }

    public void updateEmployeeStatus(int employeeId, Status newStatus) {
        employeeRepository.updateEmployeeStatus(employeeId, newStatus);
    }

    public void updateEmployeeDepartment(int employeeId, String newDepartment) {
        employeeRepository.updateEmployeeDepartment(employeeId, newDepartment);
    }
}
