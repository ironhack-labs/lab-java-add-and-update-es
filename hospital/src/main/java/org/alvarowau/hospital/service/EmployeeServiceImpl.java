package org.alvarowau.hospital.service;

import lombok.RequiredArgsConstructor;
import org.alvarowau.hospital.exception.EmployeeNotFoundException;
import org.alvarowau.hospital.model.dto.request.employee.EmployeeRequest;
import org.alvarowau.hospital.model.dto.request.employee.EmployeeUpdateRequest;
import org.alvarowau.hospital.model.dto.response.employee.EmployeePublicResponse;
import org.alvarowau.hospital.model.dto.response.employee.EmployeeResponse;
import org.alvarowau.hospital.model.entity.Employee;
import org.alvarowau.hospital.model.mapper.EmployeeDtoMapper;
import org.alvarowau.hospital.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeePublicResponse createEmployee(EmployeeRequest request) {
        try {
            Employee employee = EmployeeDtoMapper.mapToEmployee(request);
            return EmployeeDtoMapper.mapToPublicResponse(employeeRepository.save(employee));
        } catch (RuntimeException e) {
            throw new RuntimeException("Error creating employee: " + e.getMessage());
        }
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) throws EmployeeNotFoundException {
        return EmployeeDtoMapper.mapToResponse(
                employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id))
        );
    }

    @Override
    public List<EmployeePublicResponse> getAllEmployees() {
        try {
            return employeeRepository.findAll().stream()
                    .map(EmployeeDtoMapper::mapToPublicResponse)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error getting all employees: " + e.getMessage());
        }
    }

    @Override
    public EmployeePublicResponse updateEmployee(Long id, EmployeeUpdateRequest request)  {
        if (request == null) {
            throw new IllegalArgumentException("Request must not be null");
        }

        Employee employeeBD = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        if (!employeeBD.getName().equals(request.getName())) {
            employeeBD.setName(request.getName());
        }
        if (!employeeBD.getDepartment().equals(request.getDepartment())) {
            employeeBD.setDepartment(request.getDepartment());
        }
        if (!employeeBD.getStatus().equals(request.getStatus())) {
            employeeBD.setStatus(request.getStatus());
        }

        return EmployeeDtoMapper.mapToPublicResponse(employeeRepository.save(employeeBD));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }
}
