package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByDepartmentId",
        query = "SELECT e FROM Employee e WHERE e.departmentId = :departmentId"
    ),
    @NamedQuery(
        name = "Employee.findByRole",
        query = "SELECT e FROM Employee e WHERE e.role = :role"
    )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private Long departmentId;

    // Constructors, Getters, and Setters
}
