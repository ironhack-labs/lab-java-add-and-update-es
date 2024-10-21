package org.alvarowau.hospital.model.dto.request.patient;

import lombok.*;
import org.alvarowau.hospital.model.entity.Employee;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientUpdateRequest {
    private String name;
    private Long admittedById;
    private Employee employee;
}
