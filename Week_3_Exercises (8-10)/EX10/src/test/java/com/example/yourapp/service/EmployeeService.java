package com.example.yourapp.service;

import com.example.yourapp.model.Employee;
import com.example.yourapp.repository.mysql.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void batchSaveEmployees(List<Employee> employees) {
        employeeRepository.saveAllInBatch(employees);
    }

    @Transactional
    public void batchDeleteEmployees() {
        employeeRepository.deleteAllInBatch();
    }
}
