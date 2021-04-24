package com.mycompany.controller;

import com.mycompany.entity.Employee;

public class EmployeeDummyUno extends Employee {
    public EmployeeDummyUno() {
        super("x", "xx", 100.000);
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public void setFullName(String fullName) {
    }

    @Override
    public double getSalary() {
        return 0.0;
    }

    @Override
    public void setSalary(double salary) {

    }
}
