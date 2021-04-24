package com.mycompany.repository;

import com.mycompany.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    List<Employee> findAll();

    Optional<Employee> findById(String id);
}
