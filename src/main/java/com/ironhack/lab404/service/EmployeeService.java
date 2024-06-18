package com.ironhack.lab404.service;


import com.ironhack.lab404.dtos.EmployeeRequest;
import com.ironhack.lab404.dtos.EmployeeUpdateRequest;
import com.ironhack.lab404.model.Employee;
import com.ironhack.lab404.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "EmployeeRequest not found."));
    }

    public List<Employee> getByStatus (String status){
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getByDepartment (String department){
        return employeeRepository.findByDepartment(department);
    }

    // 2. Añadir un nuevo doctor
    public Employee createEmployee(EmployeeRequest receivedEmployee){

        Employee newEmployee = new Employee();
        newEmployee.setEmployeeId(receivedEmployee.getEmployeeId());
        newEmployee.setDepartment(receivedEmployee.getDepartment());
        newEmployee.setEmployeeName(receivedEmployee.getEmployeeName());
        newEmployee.setStatus(receivedEmployee.getStatus());

        return employeeRepository.save(newEmployee);
    }

    // 3. Cambiar el estado del doctor
    public void updateEmployee(Integer employeeId, EmployeeUpdateRequest employeeUpdateRequest){
        Employee foundEmployee = employeeRepository.findByEmployeeId(employeeId);

        if( employeeUpdateRequest.getDepartment() != null){
            foundEmployee.setDepartment(employeeUpdateRequest.getDepartment());
        }
        if( employeeUpdateRequest.getEmployeeName() != null){
            foundEmployee.setEmployeeName(employeeUpdateRequest.getEmployeeName());
        }
        if( employeeUpdateRequest.getStatus() != null){
            foundEmployee.setStatus(employeeUpdateRequest.getStatus());
        }

        employeeRepository.save(foundEmployee);
    }



}

