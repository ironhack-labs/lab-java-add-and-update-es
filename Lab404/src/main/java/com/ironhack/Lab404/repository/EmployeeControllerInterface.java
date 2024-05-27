package com.ironhack.Lab404.repository;

import com.ironhack.Lab404.dtos.EmployeeDTO;
import com.ironhack.Lab404.model.Employee;
import com.ironhack.Lab404.model.Status;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
public interface EmployeeControllerInterface {
    Employee addEmployee(@Valid EmployeeDTO employeeDTO);
    void updateEmployeeStatus(Integer employeeId, @Valid Status status);
    void updateEmployeeDepartment(Integer employeeId, @Valid String department);
}
