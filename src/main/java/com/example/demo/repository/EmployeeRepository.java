package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    void updateEmployeeStatus(int employeeId, Status newStatus);
    void updateEmployeeDepartment(int employeeId, String newDepartment);
}
