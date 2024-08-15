package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/role/{role}")
    public List<Employee> getEmployeesByRole(@PathVariable String role) {
        return employeeService.getEmployeesByRole(role);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long id) {
        return employeeService.getEmployeesByDepartmentId(id);
    }
}
