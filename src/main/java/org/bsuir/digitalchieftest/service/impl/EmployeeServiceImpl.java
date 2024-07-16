package org.bsuir.digitalchieftest.service.impl;

import lombok.RequiredArgsConstructor;
import org.bsuir.digitalchieftest.model.entity.Employee;
import org.bsuir.digitalchieftest.repository.EmployeeRepository;
import org.bsuir.digitalchieftest.service.EmployeeService;
import org.bsuir.digitalchieftest.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getById(UUID id) {
        return getEmployeeOrThrow(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Employee updateEmployee(UUID id, Employee employee) {
        Employee temp = getEmployeeOrThrow(id);
        temp.setCompany(employee.getCompany());
        temp.setName(employee.getName());
        temp.setPosition(employee.getPosition());
        temp.setSalary(employee.getSalary());

        return repository.save(temp);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(UUID id) {
        getEmployeeOrThrow(id);
        repository.deleteById(id);
    }

    private Employee getEmployeeOrThrow(UUID employeeId) {
        return repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        HttpStatus.NOT_FOUND.value(), "Can't find employee by id = " + employeeId));
    }

}
