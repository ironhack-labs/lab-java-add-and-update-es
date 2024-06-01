package org.ironhack.hospitalapi.controller;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/department")
    public ResponseEntity<Employee> updateEmployeeDepartment(@PathVariable Long id, @RequestBody String department) {
        Employee updatedEmployee = employeeService.updateEmployeeDepartment(id, department);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Employee> updateEmployeeStatus(@PathVariable Long id, @RequestBody String status) {
        Employee updatedEmployee = employeeService.updateEmployeeStatus(id, status);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
