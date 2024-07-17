package org.bsuir.digitalchieftest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bsuir.digitalchieftest.model.dto.request.CompanyRequest;
import org.bsuir.digitalchieftest.model.dto.response.CompanyResponse;
import org.bsuir.digitalchieftest.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompany(
            @Valid @PathVariable UUID id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.getCompany(id));
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAll() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.getCompanies());
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> createCompany(
            @Valid @RequestBody CompanyRequest company) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(companyService.createCompany(company));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponse> updateCompany(
            @Valid @PathVariable UUID id,
            @Valid @RequestBody CompanyRequest company) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(companyService.updateCompany(id, company));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(
            @Valid @PathVariable UUID id) {

        companyService.deleteCompanyById(id);
    }
}
