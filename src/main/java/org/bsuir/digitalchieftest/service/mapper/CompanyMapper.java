package org.bsuir.digitalchieftest.service.mapper;

import org.bsuir.digitalchieftest.model.dto.request.CompanyRequest;
import org.bsuir.digitalchieftest.model.dto.response.CompanyResponse;
import org.bsuir.digitalchieftest.model.entity.Company;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface CompanyMapper {

    Company toEntity(CompanyRequest companyRequest);
    List<CompanyResponse> toResponseList(List<Company> companyList);

    @Mapping(source = "employees", target = "employees")
    CompanyResponse toResponse(Company company);

    @BeanMapping(nullValuePropertyMappingStrategy
            = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Company partialUpdate(
            CompanyRequest companyRequest,
            @MappingTarget Company company);
}
