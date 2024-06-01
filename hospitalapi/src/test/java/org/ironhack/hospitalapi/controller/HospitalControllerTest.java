package org.ironhack.hospitalapi.controller;

import org.ironhack.hospitalapi.model.Employee;
import org.ironhack.hospitalapi.model.Patient;
import org.ironhack.hospitalapi.repository.EmployeeRepository;
import org.ironhack.hospitalapi.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HospitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testAddEmployee() throws Exception {
        String employeeJson = "{\"department\": \"neurology\", \"name\": \"Carlos Smith\", \"status\": \"ON_CALL\"}";
        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Carlos Smith"));
    }

    @Test
    public void testAddPatient() throws Exception {
        String patientJson = "{\"name\": \"Laura White\", \"dateOfBirth\": \"1988-08-25\", \"admittedBy\": 564134}";
        mockMvc.perform(post("/api/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(patientJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Laura White"));
    }

    @Test
    public void testChangeDoctorStatus() throws Exception {
        Optional<Employee> optionalEmployee = employeeRepository.findById(564134);
        Employee employee = optionalEmployee.orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
        mockMvc.perform(put("/api/employees/" + employee.getId() + "/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("OFF"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OFF"));
    }

    @Test
    public void testUpdateDoctorDepartment() throws Exception {
        Optional<Employee> optionalEmployee = employeeRepository.findById(564134);
        Employee employee = optionalEmployee.orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
        mockMvc.perform(patch("/api/employees/" + employee.getId() + "/department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("neurology"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.department").value("neurology"));
    }

    @Test
    public void testUpdatePatient() throws Exception {
        Optional<Patient> optionalPatient = patientRepository.findById(1);
        Patient patient = optionalPatient.orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        String updatedPatientJson = "{\"name\": \"Jaime Jordan\", \"dateOfBirth\": \"1984-03-02\", \"admittedBy\": 564134}";
        mockMvc.perform(patch("/api/patients/" + patient.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedPatientJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jaime Jordan"));
    }
}
