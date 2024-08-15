package com.example.yourapp.repository.mysql;

import com.example.yourapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    void deleteAllInBatch();

    @Transactional
    void saveAllInBatch(Iterable<Employee> employees);
}
