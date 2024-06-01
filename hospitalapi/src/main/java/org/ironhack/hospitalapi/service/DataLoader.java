package org.ironhack.hospitalapi.service;

import org.ironhack.hospitalapi.model.Employee;
import org.ironhack.hospitalapi.model.Patient;
import org.ironhack.hospitalapi.repository.EmployeeRepository;
import org.ironhack.hospitalapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        // Load employees
        employeeRepository.save(new Employee(356712, "cardiology", "Alonso Flores", "ON_CALL"));
        employeeRepository.save(new Employee(564134, "immunology", "Sam Ortega", "ON"));
        employeeRepository.save(new Employee(761527, "cardiology", "German Ruiz", "OFF"));
        employeeRepository.save(new Employee(166552, "pulmonary", "Maria Lin", "ON"));
        employeeRepository.save(new Employee(156545, "orthopaedic", "Paolo Rodriguez", "ON_CALL"));
        employeeRepository.save(new Employee(172456, "psychiatric", "John Paul Armes", "OFF"));

        // Load patients
        patientRepository.save(new Patient(1, "Jaime Jordan", "1984-03-02", 564134));
        patientRepository.save(new Patient(2, "Marian Garcia", "1972-01-12", 564134));
        patientRepository.save(new Patient(3, "Julia Dusterdieck", "1954-06-11", 356712));
        patientRepository.save(new Patient(4, "Steve McDuck", "1931-11-10", 761527));
        patientRepository.save(new Patient(5, "Marian Garcia", "1999-02-15", 172456));
    }
}
