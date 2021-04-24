package com.mycompany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.OptionalInt;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private String id;
    @Column(name = "full_name")
    private String fullName;
    private double salary;


    public Employee (){}
    public Employee(String id, String fullName, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
