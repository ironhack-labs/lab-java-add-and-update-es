package org.alvarowau.hospital.model.dto.request.employee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.alvarowau.hospital.model.entity.Patient;
import org.alvarowau.hospital.model.enums.StatusEmployee;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeUpdateRequest {
    private String name;

    private String department;

    private StatusEmployee status;

}
