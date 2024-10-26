package org.amazon.lab_4_04_put_pach.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admittedBy", referencedColumnName = "employeeId")
    private Employee admittedBy;

}

