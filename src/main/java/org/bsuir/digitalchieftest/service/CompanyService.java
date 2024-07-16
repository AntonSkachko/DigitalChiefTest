package org.bsuir.digitalchieftest.service;

import org.bsuir.digitalchieftest.model.entity.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    Company createCompany(Company company);
    Company updateCompany(UUID id, Company company);
    List<Company> getCompanies();
    Company getCompany(UUID id);
    void deleteCompanyById(UUID id);
}
