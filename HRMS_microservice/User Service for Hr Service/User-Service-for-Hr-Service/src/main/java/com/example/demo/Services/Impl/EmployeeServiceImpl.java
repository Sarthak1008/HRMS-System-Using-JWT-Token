package com.example.demo.Services.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Services.EmployeeService;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee findByEmployeeId(Integer employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return employee;
    }

    @Override
    public List<Employee> totalPresent() {
        return employeeRepository.findByStatus("P");
    }

    @Override
    public List<Employee> totalAbsent() {
        return employeeRepository.findByStatus("A");
    }

    @Override
    public List<Employee> findByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }

    @Override
    public List<Employee> findByDepartment(String departmentName) {
        return employeeRepository.findByDepartment(departmentName);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee); 
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public String deteleEmployee(Integer employeeId) {
        
        Employee demployee = employeeRepository.findByEmployeeId(employeeId);
         
        String deleted = "Deleted employee "+ demployee.getEmployeeName();
        employeeRepository.delete(demployee);
        return deleted;
    }
    
}
