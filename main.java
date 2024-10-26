// Añaditr nuevos pacientes

@PostMapping("/patients")
public ResponseEntity<Patient> addPatient(@RequestBody Patient newPatient) {
    Patient savedPatient = patientRepository.save(newPatient);
    return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
}

//Añadir nuevo doctor

@PostMapping("/employees")
public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmployee) {
    Employee savedEmployee = employeeRepository.save(newEmployee);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
}

// Cambiar estado del doctor

@PutMapping("/employees/{id}/status")
public ResponseEntity<Employee> updateDoctorStatus(@PathVariable Long id, @RequestParam String status) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    employee.setStatus(status);
    Employee updatedEmployee = employeeRepository.save(employee);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
}

// Actualizar departamento del doctor

@PutMapping("/employees/{id}/department")
public ResponseEntity<Employee> updateDoctorDepartment(@PathVariable Long id, @RequestParam String department) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    employee.setDepartment(department);
    Employee updatedEmployee = employeeRepository.save(employee);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
}

// Actualizar informacion del paciente

@PutMapping("/patients/{id}")
public ResponseEntity<Patient> updatePatientInfo(@PathVariable Long id, @RequestBody Patient updatedPatient) {
    Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
    patient.setName(updatedPatient.getName());
    patient.setDateOfBirth(updatedPatient.getDateOfBirth());
    patient.setAdmittedBy(updatedPatient.getAdmittedBy());
    Patient updatedPat = patientRepository.save(patient);
    return new ResponseEntity<>(updatedPat, HttpStatus.OK);
}