package org.bsuir.digitalchieftest.repository;

import org.bsuir.digitalchieftest.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
