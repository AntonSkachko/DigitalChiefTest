package org.bsuir.digitalchieftest.model.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class CompanyResponse {
    private UUID id;
    private String name;
    private String address;
    private LocalDate yearOfEstablishment;
    private String industry;
    private List<EmployeeResponse> employees;
}
