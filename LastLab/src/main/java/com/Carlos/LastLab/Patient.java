import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private String dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Doctor admittedBy;

    // Getters and Setters
}
@PutMapping("/patient/{id}/update")
public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
    return patientRepository.findById(id).map(patient -> {
        updatedPatient.setPatientId(id);
        patientRepository.save(updatedPatient);
        return ResponseEntity.ok("Patient information updated successfully");
    }).orElse(ResponseEntity.notFound().build());
}