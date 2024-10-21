package org.alvarowau.hospital.service;

import lombok.RequiredArgsConstructor;
import org.alvarowau.hospital.exception.PatientNotFoundException;
import org.alvarowau.hospital.model.dto.request.patient.PatientRequest;
import org.alvarowau.hospital.model.dto.request.patient.PatientUpdateRequest;
import org.alvarowau.hospital.model.dto.response.patient.PatientPublicResponse;
import org.alvarowau.hospital.model.dto.response.patient.PatientResponse;
import org.alvarowau.hospital.model.entity.Patient;
import org.alvarowau.hospital.model.mapper.PatientDtoMapper;
import org.alvarowau.hospital.repository.EmployeeRepository;
import org.alvarowau.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {
    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public PatientPublicResponse createPatient(PatientRequest request) {
        try {
            Patient patient = PatientDtoMapper.mapToPatient(request);
            return PatientDtoMapper.mapToPublicResponse(patientRepository.save(patient));
        } catch (RuntimeException e) {
            throw new RuntimeException("Error creating patient: " + e.getMessage());
        }
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        return PatientDtoMapper.mapToResponse(
                patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id))
        );
    }

    @Override
    public List<PatientPublicResponse> getAllPatients() {
        try {
            return patientRepository.findAll().stream()
                    .map(PatientDtoMapper::mapToPublicResponse)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error getting all patients: " + e.getMessage());
        }
    }

    @Override
    public PatientPublicResponse updatePatient(Long id, PatientUpdateRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request must not be null");
        }

        Patient patientBD = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        if (!patientBD.getName().equals(request.getName())) {
            patientBD.setName(request.getName());
        }

        if (request.getAdmittedById() != null && !patientBD.getAdmittedBy().getId().equals(request.getAdmittedById())) {
            if (employeeRepository.existsById(request.getAdmittedById())) {
                patientBD.setAdmittedBy(employeeRepository.findById(request.getAdmittedById())
                        .orElseThrow(() -> new IllegalArgumentException("Admitting employee not found")));
            } else {
                throw new IllegalArgumentException("Admitting employee ID not found");
            }
        }
        return PatientDtoMapper.mapToPublicResponse(patientRepository.save(patientBD));
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException(id);
        }
        patientRepository.deleteById(id);
    }
}
