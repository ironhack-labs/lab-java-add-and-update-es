package org.amazon.lab_4_04_put_pach.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    private int employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

}


