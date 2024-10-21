package org.alvarowau.hospital.model.dto.response.patient;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.alvarowau.hospital.model.entity.Employee;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String nameDoctor;
}
