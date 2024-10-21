package org.alvarowau.hospital.service;

import org.alvarowau.hospital.model.dto.request.patient.PatientRequest;
import org.alvarowau.hospital.model.dto.request.patient.PatientUpdateRequest;
import org.alvarowau.hospital.model.dto.response.patient.PatientPublicResponse;
import org.alvarowau.hospital.model.dto.response.patient.PatientResponse;

import java.util.List;

public interface IPatientService {
    PatientPublicResponse createPatient(PatientRequest request);
    PatientResponse getPatientById(Long id);
    List<PatientPublicResponse> getAllPatients();
    PatientPublicResponse updatePatient(Long id, PatientUpdateRequest request);
    void deletePatient(Long id);
}
