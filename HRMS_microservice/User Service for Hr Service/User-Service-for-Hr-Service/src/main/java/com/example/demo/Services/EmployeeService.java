package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findByEmployeeId(Integer employeeId);
    List<Employee> totalPresent();
    List<Employee> totalAbsent();
    List<Employee> findByEmployeeName(String employeeName);
    List<Employee> findByDepartment(String departmentName);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    String deteleEmployee(Integer employeeId);


    
}
