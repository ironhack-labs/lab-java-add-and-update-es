package org.amazon.lab_4_04_put_pach.Service;

import org.amazon.lab_4_04_put_pach.DTO.EmployeeAnswerDTO;
import org.amazon.lab_4_04_put_pach.DTO.EmployeeRequestDTO;
import org.amazon.lab_4_04_put_pach.Model.Employee;
import org.amazon.lab_4_04_put_pach.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeAnswerDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {

        Employee newEmployee = new Employee(employeeRequestDTO.getEmployeeId(),
                employeeRequestDTO.getDepartment(), employeeRequestDTO.getName(),
                employeeRequestDTO.getStatus());

        Employee guardadoDeEmployeDTO = employeeRepository.save(newEmployee);

        EmployeeAnswerDTO employeeAnswerDTO = new EmployeeAnswerDTO(guardadoDeEmployeDTO.getEmployeeId());
        return employeeAnswerDTO;
    }

    public Optional<Employee> updateEmployee(Integer id, Employee employee) {


        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employeeencontrado = employeeOptional.get();

            if (employee.getName() != null) {
                employeeencontrado.setName(employee.getName());
            }
            Employee emplyeeupdated = employeeRepository.save(employeeencontrado);
            return Optional.of(emplyeeupdated);

        } else {
            return Optional.empty();
        }
    }

    public Optional<Employee> employeeUpdateStatus (int id, Employee employee) {
        Optional<Employee> findEmployeeForId = employeeRepository.findByEmployeeId (id);
        if (findEmployeeForId.isPresent()) {
            Employee employeeencontrado = findEmployeeForId.get();
            employeeencontrado.setStatus(employee.getStatus());
            Employee employeeupdated = employeeRepository.save(employeeencontrado);
            return Optional.of(employeeupdated);
        } else {
            return Optional.empty();
        }


    }

    public Optional<Employee> employeeUpdateDepartment (int id, Employee employee) {
        Optional<Employee> findEmployeeFordepartment = employeeRepository.findByEmployeeId(id);
        if (findEmployeeFordepartment.isPresent()) {
            Employee departmentFound = findEmployeeFordepartment.get();
            departmentFound.setDepartment(employee.getDepartment());
            Employee employeeupdated = employeeRepository.save(departmentFound);
            return Optional.of(employeeupdated);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Employee> employeeUpdateAnyInformation (int id, Employee employee){
        Optional<Employee> findEmployeeForName = employeeRepository.findByEmployeeId(id);
        if (findEmployeeForName.isPresent()) {
            Employee employeeFound = findEmployeeForName.get();

            if (employee.getName() != null){
                employeeFound.setName(employee.getName());
            } if (employee.getDepartment() != null) {
                employeeFound.setDepartment(employee.getDepartment());
            } if (employee.getStatus() != null) {
                employeeFound.setStatus(employee.getStatus());
             }
            Employee employeeUpdated = employeeRepository.save(employeeFound);
            return Optional.of(employeeUpdated);
        } else { return Optional.empty(); }
    }
}
