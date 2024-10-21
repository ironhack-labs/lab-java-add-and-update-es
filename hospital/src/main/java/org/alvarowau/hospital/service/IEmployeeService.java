package org.alvarowau.hospital.service;

import org.alvarowau.hospital.exception.EmployeeNotFoundException;
import org.alvarowau.hospital.model.dto.request.employee.EmployeeRequest;
import org.alvarowau.hospital.model.dto.request.employee.EmployeeUpdateRequest;
import org.alvarowau.hospital.model.dto.response.employee.EmployeePublicResponse;
import org.alvarowau.hospital.model.dto.response.employee.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    EmployeePublicResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployeeById(Long id) throws EmployeeNotFoundException;
    List<EmployeePublicResponse> getAllEmployees();
    EmployeePublicResponse updateEmployee(Long id, EmployeeUpdateRequest request);
    void deleteEmployee(Long id);
}
