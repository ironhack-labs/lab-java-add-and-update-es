package com.ironhack.lab404.repository;

import com.ironhack.lab404.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByStatus(String employeeStatus);

    List<Employee>findByDepartment(String department);

    Employee findByEmployeeId(Integer employeeId);

}
