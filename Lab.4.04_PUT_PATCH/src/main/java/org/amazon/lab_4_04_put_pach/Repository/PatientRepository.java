package org.amazon.lab_4_04_put_pach.Repository;


import org.amazon.lab_4_04_put_pach.Model.Patient;
import org.amazon.lab_4_04_put_pach.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {





}


