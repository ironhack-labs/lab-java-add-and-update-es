package org.example.hospitalapi.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateEmployeeDepartmentRequest {
  @NotBlank
  private String department;
}
