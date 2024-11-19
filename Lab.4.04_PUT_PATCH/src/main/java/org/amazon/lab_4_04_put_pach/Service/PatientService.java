package org.amazon.lab_4_04_put_pach.Service;

import org.amazon.lab_4_04_put_pach.DTO.PatientAnsewerDTO;
import org.amazon.lab_4_04_put_pach.DTO.PatientRequestDTO;
import org.amazon.lab_4_04_put_pach.Model.Patient;
import org.amazon.lab_4_04_put_pach.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientAnsewerDTO createAPatient (PatientRequestDTO patientRequestDTO){
        Patient patient1 = new Patient(patientRequestDTO.getId(),patientRequestDTO.getName(),patientRequestDTO.getDateOfBirth(),null);
        Patient guardarPatient = patientRepository.save(patient1);

        PatientAnsewerDTO patientAnsewerDTO = new PatientAnsewerDTO(guardarPatient.getId());
        return patientAnsewerDTO;
    }
}
