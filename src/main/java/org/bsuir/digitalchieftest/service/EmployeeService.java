package org.bsuir.digitalchieftest.service;

import org.bsuir.digitalchieftest.model.dto.request.EmployeeRequest;
import org.bsuir.digitalchieftest.model.dto.response.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employee);
    EmployeeResponse getById(UUID id);
    List<EmployeeResponse> getEmployees();
    EmployeeResponse updateEmployee(UUID id, EmployeeRequest employee);
    void deleteEmployeeById(UUID id);
}
