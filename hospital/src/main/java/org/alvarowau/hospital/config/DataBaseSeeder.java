package org.alvarowau.hospital.config;

import org.alvarowau.hospital.model.entity.Employee;
import org.alvarowau.hospital.model.entity.Patient;
import org.alvarowau.hospital.model.enums.StatusEmployee;
import org.alvarowau.hospital.repository.EmployeeRepository;
import org.alvarowau.hospital.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataBaseSeeder {
    @Bean
    CommandLineRunner loadData(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        return args -> {
            // Creación de empleados
            Employee e1 = Employee.builder().id(356712L).department("cardiology").name("Alonso Flores").status(StatusEmployee.ON_CALL).build();
            Employee e2 = Employee.builder().id(564134L).department("immunology").name("Sam Ortega").status(StatusEmployee.ON).build();
            Employee e3 = Employee.builder().id(761527L).department("cardiology").name("German Ruiz").status(StatusEmployee.OFF).build();
            Employee e4 = Employee.builder().id(166552L).department("pulmonary").name("Maria Lin").status(StatusEmployee.ON).build();
            Employee e5 = Employee.builder().id(156545L).department("orthopaedic").name("Paolo Rodriguez").status(StatusEmployee.ON_CALL).build();
            Employee e6 = Employee.builder().id(172456L).department("psychiatric").name("John Paul Armes").status(StatusEmployee.OFF).build();

            // Guardar empleados
            employeeRepository.save(e1);
            employeeRepository.save(e2);
            employeeRepository.save(e3);
            employeeRepository.save(e4);
            employeeRepository.save(e5);
            employeeRepository.save(e6);

            // Creación de pacientes
            Patient p1 = Patient.builder().name("Jaime Jordan").birthDate(LocalDate.of(1984, 3, 2)).admittedBy(e2).build();
            Patient p2 = Patient.builder().name("Marian Garcia").birthDate(LocalDate.of(1972, 1, 12)).admittedBy(e2).build();
            Patient p3 = Patient.builder().name("Julia Dusterdieck").birthDate(LocalDate.of(1954, 6, 11)).admittedBy(e1).build();
            Patient p4 = Patient.builder().name("Steve McDuck").birthDate(LocalDate.of(1931, 11, 10)).admittedBy(e3).build();
            Patient p5 = Patient.builder().name("Marian Garcia").birthDate(LocalDate.of(1999, 2, 15)).admittedBy(e6).build();

            // Guardar pacientes
            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);
            patientRepository.save(p4);
            patientRepository.save(p5);
        };
    }
}
