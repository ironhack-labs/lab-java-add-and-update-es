package org.amazon.lab_4_04_put_pach.DTO;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientRequestDTO {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
}
