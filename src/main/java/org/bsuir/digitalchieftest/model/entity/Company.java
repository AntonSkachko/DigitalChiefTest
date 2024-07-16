package org.bsuir.digitalchieftest.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Company {

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    @NotBlank(message = "Name shouldn't be blank")
    @Size(min = 1, max = 45, message = "Name should be from 1 to 45")
    private String name;

    @NotBlank(message = "Address shouldn't be blank")
    private String address;

    @Past(message = "Time should be in the past")
    private LocalDate yearOfEstablishment;

    @NotBlank(message = "Industry shouldn't be blank")
    private String industry;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private List<Employee> employees;
}
