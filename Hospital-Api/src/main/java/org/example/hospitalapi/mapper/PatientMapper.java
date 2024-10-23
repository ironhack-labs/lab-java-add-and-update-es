package org.example.hospitalapi.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospitalapi.dtos.PatientResponse;
import org.example.hospitalapi.dtos.PostPatientRequest;
import org.example.hospitalapi.dtos.UpdatePatientRequest;
import org.example.hospitalapi.model.Employee;
import org.example.hospitalapi.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PatientMapper {
  @Autowired
  private ModelMapper modelMapper = new ModelMapper();

  public PatientResponse toDtoGetPatientResponse(Patient patient) {
    return modelMapper.map(patient, PatientResponse.class);
  }

  public List<PatientResponse> toDtoGetPatientsResponseList(List<Patient> patients) {
    return patients.stream().map(this::toDtoGetPatientResponse).collect(Collectors.toList());
  }

  public Patient fromDtoPatientResponseToPatient(PatientResponse patientResponse) {
    return modelMapper.map(patientResponse, Patient.class);
  }

  public Patient fromPostPatientRequestToPatient(PostPatientRequest patientRequest) {
    return modelMapper.map(patientRequest, Patient.class);
  }

  public PatientResponse fromPatientToDtoPatientResponse(Patient patient) {
    return modelMapper.map(patient, PatientResponse.class);
  }

}
