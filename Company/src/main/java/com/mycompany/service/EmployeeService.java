package com.mycompany.service;

import com.mycompany.entity.Employee;
import com.mycompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
}

    public Optional<Employee> getEmployee(String id) {
        return employeeRepository.findById(id);
    }
}
