package org.alvarowau.hospital.model.dto.request.patient;

import lombok.*;
import org.alvarowau.hospital.model.entity.Employee;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {
    private String name;
    private LocalDate birthDate;
    private Long admittedById;
    private Employee employee;
}
