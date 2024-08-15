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

    @GetMapping("/role/{role}")
    public List<Employee> getEmployeesByRole(@PathVariable String role) {
        return employeeService.getEmployeesByRole(role);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long departmentId) {
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }

    @GetMapping("/search/{name}")
    public List<Employee> searchEmployeesByName(@PathVariable String name) {
        return employeeService.searchEmployeesByName(name);
    }

    @GetMapping("/name-role")
    public Employee getEmployeeByNameAndRole(@RequestParam String name, @RequestParam String role) {
        return employeeService.getEmployeeByNameAndRole(name, role);
    }
}
