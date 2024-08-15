package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query method to find employees by role
    List<Employee> findByRole(String role);

    // Derived query method to find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);
}
