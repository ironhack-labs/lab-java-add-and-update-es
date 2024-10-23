package org.example.hospitalapi.dtos;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdatePatientRequest {
  private Optional<String> name;
  private Optional<LocalDate> dateOfBirth;
  private Optional<Long> employee;
}
