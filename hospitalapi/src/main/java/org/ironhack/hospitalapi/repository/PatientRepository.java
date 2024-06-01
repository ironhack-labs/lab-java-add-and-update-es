package org.ironhack.hospitalapi.repository;

import org.ironhack.hospitalapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
