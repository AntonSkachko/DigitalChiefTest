package org.bsuir.digitalchieftest.service;

import org.bsuir.digitalchieftest.model.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getById(UUID id);
    List<Employee> getEmployees();
    Employee updateEmployee(UUID id, Employee employee);
    void deleteEmployeeById(UUID id);
}
