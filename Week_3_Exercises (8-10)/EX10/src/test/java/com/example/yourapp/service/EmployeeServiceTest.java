package com.example.yourapp.service;

import com.example.yourapp.model.Employee;
import com.example.yourapp.repository.mysql.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBatchSaveEmployees() {
        List<Employee> employees = List.of(new Employee(), new Employee());
        employeeService.batchSaveEmployees(employees);
        verify(employeeRepository, times(1)).saveAllInBatch(employees);
    }

    @Test
    public void testBatchDeleteEmployees() {
        employeeService.batchDeleteEmployees();
        verify(employeeRepository, times(1)).deleteAllInBatch();
    }
}
