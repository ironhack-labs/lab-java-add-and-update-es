package com.ironhack.Lab404.service;

import com.ironhack.Lab404.dtos.EmployeeDTO;
import com.ironhack.Lab404.dtos.PatientDTO;
import com.ironhack.Lab404.model.Employee;
import com.ironhack.Lab404.model.Patient;
import com.ironhack.Lab404.model.Status;
import com.ironhack.Lab404.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setName(employeeDTO.getName());
        employee.setStatus(employeeDTO.getStatus());
        return employeeRepository.save(employee);
    }

    public void updateEmployeeStatus(Integer employeeId, Status status){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    public void updateEmployeeDepartment(Integer employeeId, String department){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

}
