package org.alvarowau.hospital.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.alvarowau.hospital.model.enums.StatusEmployee;

import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Long id;
    private String department;
    private String name;
    private StatusEmployee status;

    @OneToMany(mappedBy = "admittedBy", cascade = CascadeType.ALL)
    private List<Patient> patients;
}
