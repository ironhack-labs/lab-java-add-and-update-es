package com.ironhack.Lab404.controller;

import com.ironhack.Lab404.dtos.EmployeeDTO;
import com.ironhack.Lab404.model.Employee;
import com.ironhack.Lab404.model.Status;
import com.ironhack.Lab404.repository.EmployeeControllerInterface;
import com.ironhack.Lab404.repository.EmployeeRepository;
import com.ironhack.Lab404.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController implements EmployeeControllerInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @PatchMapping("/{employeeId}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeStatus (@PathVariable Integer employeeId, @Valid @RequestParam Status status) {
        employeeService.updateEmployeeStatus(employeeId, status);
    }

    @PutMapping("/{employeeId}/department")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployeeDepartment(@PathVariable Integer employeeId, @Valid @RequestParam String department) {
        employeeService.updateEmployeeDepartment(employeeId, department);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable(name = "id") Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByStatus(@PathVariable(name = "status") String status){
        return employeeRepository.findByStatus(Status.valueOf(status.toUpperCase()));
    }

    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByDepartment(@PathVariable(name = "department") String department){
        return employeeRepository.findByDepartment(department);
    }
}
