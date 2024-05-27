package com.ironhack.Lab404;

import com.ironhack.Lab404.repository.EmployeeRepository;
import com.ironhack.Lab404.repository.PatientRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ironhack.Lab404.model.*;

import java.text.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TestLab404 {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    List<Employee> savedEmployees;
    List<Patient> savedPatients;

    @BeforeEach
    void setUp() throws ParseException {
        List<Employee> employees = List.of(
                new Employee(356712, "cardiology", "Alonso Flores", Status.ON_CALL),
                new Employee(564134, "immunology", "Sam Ortega", Status.ON),
                new Employee(761527, "cardiology", "German Ruiz", Status.OFF),
                new Employee(166552, "pulmonary", "Maria Lin", Status.ON),
                new Employee(156545, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL),
                new Employee(172456, "psychiatric", "John Paul Armes", Status.OFF)
        );
        savedEmployees = employeeRepository.saveAll(employees);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Patient> patients = List.of(
                new Patient("Jaime Jordan", dateFormat.parse("02/03/1984"), savedEmployees.get(1)),
                new Patient("Marian Garcia", dateFormat.parse("12/01/1972"), savedEmployees.get(1)),
                new Patient("Julia Dusterdieck", dateFormat.parse("11/06/1954"), savedEmployees.get(0)),
                new Patient("Steve McDuck", dateFormat.parse("10/11/1931"), savedEmployees.get(2)),
                new Patient("Marian Garcia", dateFormat.parse("12/05/1999"), savedEmployees.get(5))
        );
        savedPatients = patientRepository.saveAll(patients);
    }

    @Test
    @DisplayName("test to validate new employees")
    public void testValidEmployee() {
        assertNotNull(savedEmployees.get(0).getEmployeeId());
        assertEquals("cardiology", savedEmployees.get(0).getDepartment());
        assertEquals("German Ruiz", savedEmployees.get(2).getName());
        assertEquals(Status.OFF, savedEmployees.get(5).getStatus());

        System.out.println("Employees created successfully");
    }

    @Test
    @DisplayName("test to validate new patients")
    public void testValidPatient() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        assertNotNull(savedPatients.get(0).getPatientId());
        assertEquals("Jaime Jordan", savedPatients.get(0).getName());
        assertEquals(dateFormat.parse("12/01/1972"), savedPatients.get(1).getDateOfBirth());
        assertEquals(761527, savedPatients.get(3).getAdmittedBy().getEmployeeId());

        System.out.println("Patients created successfully");
    }
}
