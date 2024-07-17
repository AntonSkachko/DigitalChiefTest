package org.bsuir.digitalchieftest.service.impl;

import lombok.RequiredArgsConstructor;
import org.bsuir.digitalchieftest.model.dto.request.CompanyRequest;
import org.bsuir.digitalchieftest.model.dto.response.CompanyResponse;
import org.bsuir.digitalchieftest.model.entity.Company;
import org.bsuir.digitalchieftest.repository.CompanyRepository;
import org.bsuir.digitalchieftest.service.CompanyService;
import org.bsuir.digitalchieftest.service.exception.ResourceNotFoundException;
import org.bsuir.digitalchieftest.service.mapper.CompanyMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    @Override
    public CompanyResponse createCompany(CompanyRequest company) {
        return mapper.toResponse(repository.save(mapper.toEntity(company)));
    }

    @Override
    public CompanyResponse updateCompany(UUID id, CompanyRequest company) {
        return mapper.toResponse(repository.save(mapper.partialUpdate(company, getCompanyOrThrow(id))));
    }

    @Override
    public List<CompanyResponse> getCompanies() {
        return mapper.toResponseList(repository.findAll());
    }

    @Override
    public CompanyResponse getCompany(UUID id) {
        return mapper.toResponse(getCompanyOrThrow(id));
    }

    @Override
    public void deleteCompanyById(UUID id) {
        getCompanyOrThrow(id);
        repository.deleteById(id);
    }

    private Company getCompanyOrThrow(UUID companyId) {
        return repository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        HttpStatus.NOT_FOUND.value(), "Can't find company by id = " + companyId));
    }
}
