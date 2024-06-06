package com.miguelprojects.lab_404_Add_And_Update.repository;

import com.miguelprojects.lab_404_Add_And_Update.Enums.Status;
import com.miguelprojects.lab_404_Add_And_Update.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByStatus(Status status);
    List<Employee> findByDepartment(String department);

}
