package org.ironhack.lab4_04.repository;

import org.ironhack.lab4_04.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
