package org.alvarowau.hospital.model.dto.request.employee;

import lombok.*;
import org.alvarowau.hospital.model.enums.StatusEmployee;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private Long id;

    private String name;

    private String department;

    private StatusEmployee status;
}
