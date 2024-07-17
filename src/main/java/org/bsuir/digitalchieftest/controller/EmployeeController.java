package org.bsuir.digitalchieftest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bsuir.digitalchieftest.model.dto.request.EmployeeRequest;
import org.bsuir.digitalchieftest.model.dto.response.EmployeeResponse;
import org.bsuir.digitalchieftest.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(
            @Valid @PathVariable UUID id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.getEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(
            @Valid @RequestBody EmployeeRequest employee) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @Valid @PathVariable UUID id,
            @Valid @RequestBody EmployeeRequest employee) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.updateEmployee(id, employee));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(
            @Valid @PathVariable UUID id) {
        employeeService.deleteEmployeeById(id);
    }

}
