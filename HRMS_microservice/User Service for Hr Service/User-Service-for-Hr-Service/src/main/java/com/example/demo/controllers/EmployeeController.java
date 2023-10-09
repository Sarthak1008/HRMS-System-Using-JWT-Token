package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.EmployeeService;
import com.example.demo.entities.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    public EmployeeService employeeService;

    @GetMapping(value="/getAllEmployees")
    public List<Employee> getAllProducts() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value="/getEmployeeById/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeService.findByEmployeeId(employeeId);    
    }

    @GetMapping(value="/getTotalPresent")
    public List<Employee> getTotalPresent() {
        return employeeService.totalPresent();
    }

    @GetMapping(value="/getTotalAbsent")
    public List<Employee> getTotalAbsent() {
        return employeeService.totalAbsent();
    }

    @GetMapping(value="/getEmployeeByName/{employeeName}")
    public List<Employee> getEmployeeByName(@PathVariable("employeeName") String employeeName) {
           return employeeService.findByEmployeeName(employeeName);
    
    }

    @GetMapping(value="/getEmployeeByDepartment/{departmentName}")
    public List<Employee> getEmployeeByDepartment(@PathVariable("departmentName") String departmentName) {
           return employeeService.findByDepartment(departmentName);
    }
    
    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping(value="/updateEmployee/{employeeId}")
    public Employee updateEmployee(@PathVariable(value = "employeeId") int employeeId,@RequestBody Employee employee) {

            Employee existEmployee = employeeService.findByEmployeeId(employeeId);
            existEmployee.setDepartment(employee.getDepartment());
            existEmployee.setEmployeeName(existEmployee.getEmployeeName());
            existEmployee.setStatus(existEmployee.getStatus());

            Employee updatedEmployee = employeeService.updateEmployee(existEmployee);
            return updatedEmployee;
        
    }
    @DeleteMapping(value="/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeService.deteleEmployee(employeeId);
    } 

    
}
