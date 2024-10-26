package org.amazon.lab_4_04_put_pach.Controller;


import org.amazon.lab_4_04_put_pach.DTO.EmployeeAnswerDTO;
import org.amazon.lab_4_04_put_pach.DTO.EmployeeRequestDTO;
import org.amazon.lab_4_04_put_pach.Model.Employee;
import org.amazon.lab_4_04_put_pach.Repository.EmployeeRepository;
import org.amazon.lab_4_04_put_pach.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeAnswerDTO> createEmployee(@RequestBody EmployeeRequestDTO employee) {
        EmployeeAnswerDTO employeeAnswerDTO = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeAnswerDTO);
    }

    @PatchMapping("/{id}/update_employee")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> optionalEmployee = employeeService.updateEmployee(id, employee);
        if (optionalEmployee.isPresent()) {
            return ResponseEntity.ok(optionalEmployee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/update_employee_status")
    public ResponseEntity<Employee> updateEmployeeName(@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> employeeAnswer = employeeService.employeeUpdateStatus(id, employee);
        if (employeeAnswer.isPresent()) {
            return ResponseEntity.ok(employeeAnswer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping ("/{id}/update_department")
    public ResponseEntity<Employee> updateDepartment (@PathVariable int id, @RequestBody Employee employee) {
        Optional<Employee> employeeAnswer = employeeService.employeeUpdateDepartment(id,employee);
        if (employeeAnswer.isPresent()) {
            return ResponseEntity.ok(employeeAnswer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/update_any_information")
    public ResponseEntity<Employee> updateAnyInformation(@PathVariable int id, @RequestBody Employee employee) {
    Optional<Employee> employeeAnswer = employeeService.employeeUpdateAnyInformation(id,employee);
    if (employeeAnswer.isPresent()) {
        return ResponseEntity.ok(employeeAnswer.get());
    } else {
        return ResponseEntity.notFound().build();
    }
    }
}
