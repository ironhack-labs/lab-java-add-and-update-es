import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/addDoctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor newDoctor) {
        doctorRepository.save(newDoctor);
        return ResponseEntity.ok("Doctor added successfully");
    }

    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody Patient newPatient) {
        // Ensure admitted_by is a valid doctor
        if (doctorRepository.existsById(newPatient.getAdmittedBy().getEmployeeId())) {
            patientRepository.save(newPatient);
            return ResponseEntity.ok("Patient added successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid doctor ID");
        }
    }

    // Ejemplo adicional para una actualización, usando PUT
    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        if (patientRepository.existsById(id)) {
            updatedPatient.setPatientId(id);
            patientRepository.save(updatedPatient);
            return ResponseEntity.ok("Patient updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}