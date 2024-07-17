package org.bsuir.digitalchieftest.service.mapper;

import org.bsuir.digitalchieftest.model.dto.request.EmployeeRequest;
import org.bsuir.digitalchieftest.model.dto.response.EmployeeResponse;
import org.bsuir.digitalchieftest.model.entity.Employee;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface EmployeeMapper {

    @Mapping(source = "company.id", target = "companyId")
    EmployeeResponse toResponse(Employee employee);

    @Mapping(source = "companyId", target = "company.id")
    Employee toEntity(EmployeeRequest employeeRequest);

    List<EmployeeResponse> toResponseList(List<Employee> employees);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    Employee partialUpdate(EmployeeRequest employeeRequest, @MappingTarget Employee employee);

}
