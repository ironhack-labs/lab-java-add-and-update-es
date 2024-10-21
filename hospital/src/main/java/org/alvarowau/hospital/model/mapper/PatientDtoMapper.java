package org.alvarowau.hospital.model.mapper;

import org.alvarowau.hospital.model.dto.request.patient.PatientRequest;
import org.alvarowau.hospital.model.dto.request.patient.PatientUpdateRequest;
import org.alvarowau.hospital.model.dto.response.patient.PatientPublicResponse;
import org.alvarowau.hospital.model.dto.response.patient.PatientResponse;
import org.alvarowau.hospital.model.entity.Patient;

public class PatientDtoMapper {

    private PatientDtoMapper() {
    }

    public static Patient mapToPatient(PatientRequest request) {
        if (request == null || request.getEmployee() == null) {
            throw new IllegalArgumentException("Request and employee cannot be null");
        }
        return Patient.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .admittedBy(request.getEmployee())
                .build();
    }

    public static Patient mapToUpdatedPatient(PatientUpdateRequest request, Patient existingPatient) {
        if (request == null || existingPatient == null) {
            throw new IllegalArgumentException("Request and existing patient cannot be null");
        }

        Patient updatedPatient = new Patient();
        updatedPatient.setId(existingPatient.getId());
        updatedPatient.setBirthDate(existingPatient.getBirthDate());

        updatedPatient.setName(request.getName() != null ? request.getName() : existingPatient.getName());
        updatedPatient.setAdmittedBy(request.getEmployee() != null ? request.getEmployee() : existingPatient.getAdmittedBy());

        return updatedPatient;
    }

    public static PatientPublicResponse mapToPublicResponse(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        return PatientPublicResponse.builder()
                .name(patient.getName())
                .nameDoctor(patient.getAdmittedBy() != null ? patient.getAdmittedBy().getName() : "Unknown") // Manejo de null
                .build();
    }

    public static PatientResponse mapToResponse(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .birthDate(patient.getBirthDate())
                .nameDoctor(patient.getAdmittedBy() != null ? patient.getAdmittedBy().getName() : "Unknown") // Manejo de null
                .build();
    }
}
