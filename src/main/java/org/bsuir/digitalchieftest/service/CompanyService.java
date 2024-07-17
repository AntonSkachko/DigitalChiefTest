package org.bsuir.digitalchieftest.service;

import org.bsuir.digitalchieftest.model.dto.request.CompanyRequest;
import org.bsuir.digitalchieftest.model.dto.response.CompanyResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    CompanyResponse createCompany(CompanyRequest company);
    CompanyResponse updateCompany(UUID id, CompanyRequest company);
    List<CompanyResponse> getCompanies();
    CompanyResponse getCompany(UUID id);
    void deleteCompanyById(UUID id);
}
