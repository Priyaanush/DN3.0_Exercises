package com.example.service;

import com.example.dto.DepartmentDTO;
import com.example.projection.DepartmentNameProjection;
import com.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentNameProjection> getDepartmentNames() {
        return departmentRepository.findAllProjectedBy();
    }

    public List<DepartmentDTO> getDepartmentsWithEmployeeCount() {
        return departmentRepository.findDepartmentWithEmployeeCount();
    }
}
