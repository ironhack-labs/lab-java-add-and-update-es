package com.example.hospitalDb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    private Long employeeId;
    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ON_CALL, ON, OFF
    }
}
