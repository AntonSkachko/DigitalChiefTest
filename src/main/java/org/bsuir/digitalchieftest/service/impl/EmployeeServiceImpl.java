package org.bsuir.digitalchieftest.service.impl;

import lombok.RequiredArgsConstructor;
import org.bsuir.digitalchieftest.model.dto.request.EmployeeRequest;
import org.bsuir.digitalchieftest.model.dto.response.EmployeeResponse;
import org.bsuir.digitalchieftest.model.entity.Employee;
import org.bsuir.digitalchieftest.repository.EmployeeRepository;
import org.bsuir.digitalchieftest.service.EmployeeService;
import org.bsuir.digitalchieftest.service.exception.ResourceNotFoundException;
import org.bsuir.digitalchieftest.service.mapper.EmployeeMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    @Transactional
    public EmployeeResponse createEmployee(EmployeeRequest employee) {
        return mapper.toResponse(repository.save(mapper.toEntity(employee)));
    }

    @Override
    public EmployeeResponse getById(UUID id) {
        return mapper.toResponse(getEmployeeOrThrow(id));
    }

    @Override
    public List<EmployeeResponse> getEmployees() {
        return mapper.toResponseList(repository.findAll());
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(UUID id, EmployeeRequest employee) {
        return mapper.toResponse(repository.save(mapper.partialUpdate(employee, getEmployeeOrThrow(id))));
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
