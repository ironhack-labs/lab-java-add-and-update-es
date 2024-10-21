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
    @Enumerated(EnumType.STRING) // Para almacenar el valor de la enumeración como String en la base de datos
    @Column(name = "status")
    private StatusEmployee status;

    @OneToMany(mappedBy = "admittedBy", cascade = CascadeType.ALL)
    private List<Patient> patients;
}
