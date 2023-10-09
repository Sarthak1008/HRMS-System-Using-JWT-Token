package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmployeeId(Integer employeeId);
    List<Employee> findByEmployeeName(String employeeName);
    List<Employee> findByDepartment(String department);
    List<Employee> findByStatus(String status);
    
    
}
