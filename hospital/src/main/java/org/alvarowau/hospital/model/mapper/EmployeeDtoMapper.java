package org.alvarowau.hospital.model.mapper;

import org.alvarowau.hospital.model.dto.request.employee.EmployeeRequest;
import org.alvarowau.hospital.model.dto.request.employee.EmployeeUpdateRequest;
import org.alvarowau.hospital.model.dto.response.employee.EmployeePublicResponse;
import org.alvarowau.hospital.model.dto.response.employee.EmployeeResponse;
import org.alvarowau.hospital.model.entity.Employee;

public class EmployeeDtoMapper {

    private EmployeeDtoMapper() {
    }

    public static Employee mapToEmployee(EmployeeRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("EmployeeRequest cannot be null");
        }

        return Employee.builder()
                .id(request.getId())
                .name(request.getName())
                .department(request.getDepartment())
                .status(request.getStatus())
                .build();
    }

    public static Employee mapToUpdatedEmployee(Employee existingEmployee, EmployeeUpdateRequest request) {
        if (existingEmployee == null) {
            throw new IllegalArgumentException("Existing employee cannot be null");
        }
        if (request == null) {
            throw new IllegalArgumentException("EmployeeUpdateRequest cannot be null");
        }

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(existingEmployee.getId());
        updatedEmployee.setName(request.getName() != null ? request.getName() : existingEmployee.getName());
        updatedEmployee.setDepartment(request.getDepartment() != null ? request.getDepartment() : existingEmployee.getDepartment());
        updatedEmployee.setStatus(request.getStatus() != null ? request.getStatus() : existingEmployee.getStatus());

        return updatedEmployee;
    }

    public static EmployeePublicResponse mapToPublicResponse(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        return EmployeePublicResponse.builder()
                .name(employee.getName())
                .department(employee.getDepartment())
                .status(employee.getStatus())
                .build();
    }

    public static EmployeeResponse mapToResponse(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .department(employee.getDepartment())
                .status(employee.getStatus())
                .build();
    }
}
