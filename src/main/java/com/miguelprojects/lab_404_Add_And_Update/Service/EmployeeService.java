package com.miguelprojects.lab_404_Add_And_Update.Service;

import com.miguelprojects.lab_404_Add_And_Update.DTOs.EmployeeDTO;
import com.miguelprojects.lab_404_Add_And_Update.Enums.Status;
import com.miguelprojects.lab_404_Add_And_Update.controller.EmployeeController;
import com.miguelprojects.lab_404_Add_And_Update.model.Employee;
import com.miguelprojects.lab_404_Add_And_Update.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee (Employee employee){

        return employeeRepository.save(employee);
    }

    public void updateEmployee (Long idEmployee, EmployeeDTO employeeDTO){
        Employee employee = employeeRepository.findById(idEmployee).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));

//        if (employeeDTO.getEmployeeId() != null) {
//            employee.setEmployeeId(employeeDTO.getEmployeeId());
//        }
        if (employeeDTO.getDepartment() != null) {
            employee.setDepartment(employeeDTO.getDepartment());
        }
        if (employeeDTO.getName() != null) {
            employee.setName(employeeDTO.getName());
        }

        if (employeeDTO.getStatus() != null) {
            employee.setStatus(employeeDTO.getStatus());
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee (Long idEmployee){
        employeeRepository.deleteById(idEmployee);
    }

    // Cambiar el estado del doctor
    public void changeStatus (Long idEmployee, Status status) {
        Employee doctor = employeeRepository.findById(idEmployee).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee " + idEmployee +" not found"));

        doctor.setStatus(status);
        employeeRepository.save(doctor);
    }

    // Actualizar el departamento del doctor
    public void changeDepartment (Long idEmployee, String department) {
        Employee doctor = employeeRepository.findById(idEmployee).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee " + idEmployee +" not found"));

        doctor.setDepartment(department);
        employeeRepository.save(doctor);
    }
}
