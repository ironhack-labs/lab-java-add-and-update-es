package org.alvarowau.hospital.model.dto.response.patient;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientPublicResponse {
    private String name;
    private String nameDoctor;
}
