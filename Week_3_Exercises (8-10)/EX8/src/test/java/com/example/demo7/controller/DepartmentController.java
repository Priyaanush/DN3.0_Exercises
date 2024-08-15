package com.example.controller;

import com.example.dto.DepartmentDTO;
import com.example.projection.DepartmentNameProjection;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/names")
    public List<DepartmentNameProjection> getDepartmentNames() {
        return departmentService.getDepartmentNames();
    }

    @GetMapping("/with-employee-count")
    public List<DepartmentDTO> getDepartmentsWithEmployeeCount() {
        return departmentService.getDepartmentsWithEmployeeCount();
    }
}
