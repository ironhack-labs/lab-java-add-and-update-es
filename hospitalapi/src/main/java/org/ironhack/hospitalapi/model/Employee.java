package org.ironhack.hospitalapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity
// Employee.java
public class Employee {
    private int employeeId;
    @Getter
    private String department;
    @Getter
    private String name;
    @Getter
    private String status;
    @Getter
    @Id
    private Long id;

    public Employee(int employeeId, String department, String name, String status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Employee() {

    }


    // Getters and setters
    public int getId() {
        return employeeId;
    }


}
