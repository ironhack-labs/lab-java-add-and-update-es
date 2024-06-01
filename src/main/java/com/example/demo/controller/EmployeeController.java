package com.example.demo.controller;


import com.example.demo.DTO.CreateEmployeeRequest;
import com.example.demo.DTO.UpdateEmployeeDepartment;
import com.example.demo.DTO.UpdateEmployeeRequest;
import com.example.demo.DTO.UpdateEmployeeStatus;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Agregar nuevo doctor
    @PostMapping
    public Employee createEmployee(@RequestBody CreateEmployeeRequest employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    // Cambiar el estado del doctor
    @PutMapping("/{employeeId}/status")
    public void updateEmployeeStatus(@PathVariable int employeeId, @RequestBody UpdateEmployeeStatus dto) {
        employeeService.updateEmployeeStatus(employeeId, dto.getNewStatus());
    }

    // Actualizar el departamento del doctor
    @PutMapping("/{employeeId}/department")
    public void updateEmployeeDepartment(@PathVariable int employeeId, @RequestBody UpdateEmployeeDepartment dto) {
        employeeService.updateEmployeeDepartment(employeeId, dto.getNewDepartment());
    }
}
