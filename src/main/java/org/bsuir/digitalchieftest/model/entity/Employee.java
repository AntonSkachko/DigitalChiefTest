package org.bsuir.digitalchieftest.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
public class Employee{
    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    @NotBlank(message = "Name shouldn't be blank")
    @Size(min = 1, max = 45, message = "Name should be from 1 to 45")
    private String name;

    @NotBlank(message = "Position shouldn't be blank")
    private String position;

    @NotBlank(message = "Salary shouldn't be blank")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
