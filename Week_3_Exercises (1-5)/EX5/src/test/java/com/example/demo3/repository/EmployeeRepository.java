package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by role
    List<Employee> findByRole(String role);

    // Find employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Find employees whose name contains a string (case-insensitive)
    List<Employee> findByNameContainingIgnoreCase(String name);

    // Find employee by name and role
    Employee findByNameAndRole(String name, String role);

    // Custom query to find employees by department ID
    @Query("SELECT e FROM Employee e WHERE e.departmentId = :departmentId")
    List<Employee> findEmployeesByDepartmentId(@Param("departmentId") Long departmentId);

    // Custom query to find employees whose role starts with a string
    @Query("SELECT e FROM Employee e WHERE e.role LIKE :rolePrefix%")
    List<Employee> findByRoleStartingWith(@Param("rolePrefix") String rolePrefix);
}
