import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    private Long employeeId;
    private String department;
    private String name;
    private String status;

    // Getters and Setters
}
@PutMapping("/doctor/{id}/updateStatus")
public ResponseEntity<String> updateDoctorStatus(@PathVariable Long id, @RequestBody String newStatus) {
    return doctorRepository.findById(id).map(doctor -> {
        doctor.setStatus(newStatus);
        doctorRepository.save(doctor);
        return ResponseEntity.ok("Doctor status updated successfully");
    }).orElse(ResponseEntity.notFound().build());
}
@PutMapping("/doctor/{id}/updateDepartment")
public ResponseEntity<String> updateDoctorDepartment(@PathVariable Long id, @RequestBody String newDepartment) {
    return doctorRepository.findById(id).map(doctor -> {
        doctor.setDepartment(newDepartment);
        doctorRepository.save(doctor);
        return ResponseEntity.ok("Doctor department updated successfully");
    }).orElse(ResponseEntity.notFound().build());
}