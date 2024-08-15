package com.example.repository;

import com.example.dto.EmployeeDTO;
import com.example.model.Employee;
import com.example.projection.EmployeeNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<EmployeeNameProjection> findAllProjectedBy();

    @Query("SELECT new com.example.dto.EmployeeDTO(e.name, d.name) FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findEmployeeWithDepartment();
}
