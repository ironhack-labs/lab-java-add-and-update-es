package com.ironhack.lab404.repository;

import com.ironhack.lab404.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByAdmittedBy_Department(String department);

    List<Patient> findByAdmittedBy_Status(String status);

    List<Patient> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

    Patient findByPatientId(Integer patientId);


}
