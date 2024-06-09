package com.ironhack.addupdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.addupdate.model.Patient;

/**
 * PatientRepository
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
