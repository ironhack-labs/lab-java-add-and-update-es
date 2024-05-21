package org.ironhack.hospitalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatienceRepository extends JpaRepository<Patient, Long> {
}
