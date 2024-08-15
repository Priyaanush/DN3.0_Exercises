package com.example.repository;

import com.example.dto.DepartmentDTO;
import com.example.model.Department;
import com.example.projection.DepartmentNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<DepartmentNameProjection> findAllProjectedBy();

    @Query("SELECT new com.example.dto.DepartmentDTO(d.name, COUNT(e)) FROM Department d JOIN d.employees e GROUP BY d.name")
    List<DepartmentDTO> findDepartmentWithEmployeeCount();
}
