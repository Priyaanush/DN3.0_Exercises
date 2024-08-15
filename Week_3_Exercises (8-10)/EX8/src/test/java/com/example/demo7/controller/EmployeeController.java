package com.example.controller;

import com.example.dto.EmployeeDTO;
import com.example.projection.EmployeeNameProjection;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/names")
    public List<EmployeeNameProjection> getEmployeeNames() {
        return employeeService.getEmployeeNames();
    }

    @GetMapping("/with-department")
    public List<EmployeeDTO> getEmployeesWithDepartments() {
        return employeeService.getEmployeesWithDepartments();
    }
}
