package com.ironhack.addupdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.addupdate.model.Employee;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
