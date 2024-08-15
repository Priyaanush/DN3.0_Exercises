package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.projection.EmployeeNameProjection;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeNameProjection> getEmployeeNames() {
        return employeeRepository.findAllProjectedBy();
    }

    public List<EmployeeDTO> getEmployeesWithDepartments() {
        return employeeRepository.findEmployeeWithDepartment();
    }
}
