package org.ironhack.lab4_04.repository;

import org.ironhack.lab4_04.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
