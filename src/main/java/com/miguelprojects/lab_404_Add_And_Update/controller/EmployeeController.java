package com.miguelprojects.lab_404_Add_And_Update.controller;

import com.miguelprojects.lab_404_Add_And_Update.DTOs.EmployeeDTO;
import com.miguelprojects.lab_404_Add_And_Update.Enums.Status;
import com.miguelprojects.lab_404_Add_And_Update.Service.EmployeeService;
import com.miguelprojects.lab_404_Add_And_Update.model.Employee;
import com.miguelprojects.lab_404_Add_And_Update.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;


//    Obtener todos los médicos (doctors): Crear una ruta para obtener todos los médicos.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

//    Obtener médico por ID: Crear una ruta para obtener un médico por employee_id.
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }

//    Obtener médicos por estado (status): Crear una ruta para obtener médicos por status.
    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByStatus(@RequestParam Status status) {
        return employeeRepository.findByStatus(status);
    }

//    Obtener médicos por departamento: Crear una ruta para obtener médicos por department.
    @GetMapping("/department")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByDepartment(@RequestParam String department) {
        return employeeRepository.findByDepartment(department);
    }

    // Añadir nuevo doctor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Actualizar la información del doctor:
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable(name = "id") Long employeeId, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeId, employeeDTO);
    }

    // Cambiar el estado del doctor
    @PatchMapping("/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeStatus(@RequestParam(name = "id") Long idEmployee, @RequestParam Status status) {
        employeeService.changeStatus(idEmployee, status);
    }

    // Cambiar el departamento del doctor
    @PatchMapping("/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeDepartment(@RequestParam(name = "id") Long idEmployee, @RequestParam String department) {
        employeeService.changeDepartment(idEmployee, department);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
