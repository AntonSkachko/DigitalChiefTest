package org.bsuir.digitalchieftest.service.impl;

import lombok.RequiredArgsConstructor;
import org.bsuir.digitalchieftest.model.entity.Company;
import org.bsuir.digitalchieftest.repository.CompanyRepository;
import org.bsuir.digitalchieftest.service.CompanyService;
import org.bsuir.digitalchieftest.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    @Override
    public Company createCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public Company updateCompany(UUID id, Company company) {

        Company temp = getCompanyOrThrow(id);
        temp.setAddress(company.getAddress());
        temp.setName(company.getName());
        temp.setIndustry(company.getIndustry());
        temp.setYearOfEstablishment(company.getYearOfEstablishment());
        return repository.save(temp);
    }

    @Override
    public List<Company> getCompanies() {
        return repository.findAll();
    }

    @Override
    public Company getCompany(UUID id) {
        return getCompanyOrThrow(id);
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
