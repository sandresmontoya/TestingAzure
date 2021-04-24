package com.mycompany.controller;

import com.mycompany.entity.Employee;
import com.mycompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/health")
    public String state(){
        return "Success";
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") String id){
        return employeeService.getEmployee(id);
    }
}
