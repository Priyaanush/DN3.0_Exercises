package com.example.yourapp.controller;

import com.example.yourapp.model.Employee;
import com.example.yourapp.service.EmployeeService;
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

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/batch")
    public void batchSaveEmployees(@RequestBody List<Employee> employees) {
        employeeService.batchSaveEmployees(employees);
    }

    @DeleteMapping("/batch")
    public void batchDeleteEmployees() {
        employeeService.batchDeleteEmployees();
    }
}
