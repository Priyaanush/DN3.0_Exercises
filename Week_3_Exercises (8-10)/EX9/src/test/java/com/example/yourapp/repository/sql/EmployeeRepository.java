package com.example.yourapp.repository.mysql;

import com.example.yourapp.model.mysql.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
