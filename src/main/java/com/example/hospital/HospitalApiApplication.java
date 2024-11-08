package com.example.hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmpleadoRepository empleadoRepository, PacienteRepository pacienteRepository) {
        return (args) -> {
            Empleado sam = new Empleado("564134", "Sam Ortega", "Inmunología", "ON");
            Empleado jaime = new Empleado("356712", "Alonso Flores", "Cardiología", "ON_CALL");
            empleadoRepository.save(sam);
            empleadoRepository.save(jaime);

            Paciente paciente = new Paciente(1, "Jaime Jordan", LocalDate.of(1984, 3, 2), sam);
            pacienteRepository.save(paciente);
        };
    }

    @Entity
    public static class Empleado {

        @Id
        private String employeeId;
        private String nombre;
        private String departamento;
        private String estado;

        public Empleado() {}

        public Empleado(String employeeId, String nombre, String departamento, String estado) {
            this.employeeId = employeeId;
            this.nombre = nombre;
            this.departamento = departamento;
            this.estado = estado;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDepartamento() {
            return departamento;
        }

        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }

    @Entity
    public static class Paciente {

        @Id
        private int idPaciente;
        private String nombre;
        private LocalDate fechaDeNacimiento;

        @ManyToOne
        @JoinColumn(name = "admitido_por")
        private Empleado admitidoPor;

        public Paciente() {}

        public Paciente(int idPaciente, String nombre, LocalDate fechaDeNacimiento, Empleado admitidoPor) {
            this.idPaciente = idPaciente;
            this.nombre = nombre;
            this.fechaDeNacimiento = fechaDeNacimiento;
            this.admitidoPor = admitidoPor;
        }

        public int getIdPaciente() {
            return idPaciente;
        }

        public void setIdPaciente(int idPaciente) {
            this.idPaciente = idPaciente;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public LocalDate getFechaDeNacimiento() {
            return fechaDeNacimiento;
        }

        public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
        }

        public Empleado getAdmitidoPor() {
            return admitidoPor;
        }

        public void setAdmitidoPor(Empleado admitidoPor) {
            this.admitidoPor = admitidoPor;
        }
    }

    public interface EmpleadoRepository extends JpaRepository<Empleado, String> {}

    public interface PacienteRepository extends JpaRepository<Paciente, Integer> {}

    @RestController
    @RequestMapping("/api")
    public static class HospitalController {

        @Autowired
        private EmpleadoRepository empleadoRepository;

        @Autowired
        private PacienteRepository pacienteRepository;

        @PostMapping("/pacientes")
        public Paciente agregarPaciente(@RequestBody Paciente paciente) {
            return pacienteRepository.save(paciente);
        }

        @PostMapping("/empleados")
        public Empleado agregarEmpleado(@RequestBody Empleado empleado) {
            return empleadoRepository.save(empleado);
        }

        @PutMapping("/empleados/{employeeId}/estado")
        public Empleado cambiarEstadoDoctor(@PathVariable String employeeId, @RequestBody String estado) {
            Empleado empleado = empleadoRepository.findById(employeeId).orElseThrow();
            empleado.setEstado(estado);
            return empleadoRepository.save(empleado);
        }

        @PutMapping("/empleados/{employeeId}/departamento")
        public Empleado actualizarDepartamento(@PathVariable String employeeId, @RequestBody String departamento) {
            Empleado empleado = empleadoRepository.findById(employeeId).orElseThrow();
            empleado.setDepartamento(departamento);
            return empleadoRepository.save(empleado);
        }

        @PutMapping("/pacientes/{idPaciente}")
        public Paciente actualizarPaciente(@PathVariable int idPaciente, @RequestBody Paciente paciente) {
            Paciente pacienteExistente = pacienteRepository.findById(idPaciente).orElseThrow();
            pacienteExistente.setNombre(paciente.getNombre());
            pacienteExistente.setFechaDeNacimiento(paciente.getFechaDeNacimiento());
            pacienteExistente.setAdmitidoPor(paciente.getAdmitidoPor());
            return pacienteRepository.save(pacienteExistente);
        }
    }
}