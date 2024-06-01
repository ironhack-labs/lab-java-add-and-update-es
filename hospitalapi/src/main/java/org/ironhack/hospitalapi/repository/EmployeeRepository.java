package org.ironhack.hospitalapi.repository;

import org.ironhack.hospitalapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
