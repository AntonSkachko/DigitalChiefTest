package org.bsuir.digitalchieftest.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeRequest {

    @NotBlank(message = "Name shouldn't be blank")
    @Size(min = 1, max = 45, message = "Name should be from 1 to 45")
    private String name;

    @NotBlank(message = "Position shouldn't be blank")
    private String position;
    private Double salary;
    private UUID companyId;
}
