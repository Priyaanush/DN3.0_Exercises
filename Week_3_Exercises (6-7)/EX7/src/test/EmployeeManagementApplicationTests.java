package com.example;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeManagementApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Transactional
    public void testAuditingFields() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee = employeeRepository.save(employee);

        assertNotNull(employee.getCreatedBy());
        assertNotNull(employee.getCreatedDate());
        assertNull(employee.getLastModifiedBy());
        assertNull(employee.getLastModifiedDate());

        // Simulate an update
        employee.set
