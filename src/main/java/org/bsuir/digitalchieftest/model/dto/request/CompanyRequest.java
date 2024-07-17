package org.bsuir.digitalchieftest.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CompanyRequest {

    @NotBlank(message = "Name shouldn't be blank")
    @Size(min = 1, max = 45, message = "Name should be from 1 to 45")
    private String name;

    @NotBlank(message = "Address shouldn't be blank")
    private String address;

    @Past(message = "Time should be in the past")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate yearOfEstablishment;

    @NotBlank(message = "Industry shouldn't be blank")
    private String industry;
}
