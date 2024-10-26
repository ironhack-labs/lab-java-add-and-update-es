package org.amazon.lab_4_04_put_pach.DTO;

import jakarta.persistence.Id;
import lombok.*;
import org.amazon.lab_4_04_put_pach.Model.Status;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRequestDTO {

    private int employeeId;
    private String department;
    private String name;
    private Status status;
}
