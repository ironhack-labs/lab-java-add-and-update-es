package org.amazon.lab_4_04_put_pach.Repository;


import org.amazon.lab_4_04_put_pach.Model.Employee;
import org.amazon.lab_4_04_put_pach.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeId (int id);

}
