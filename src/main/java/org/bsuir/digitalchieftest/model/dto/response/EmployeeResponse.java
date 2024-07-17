package org.bsuir.digitalchieftest.model.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeResponse {
    private UUID id;
    private String name;
    private String position;
    private Double salary;
    private UUID companyId;
}
