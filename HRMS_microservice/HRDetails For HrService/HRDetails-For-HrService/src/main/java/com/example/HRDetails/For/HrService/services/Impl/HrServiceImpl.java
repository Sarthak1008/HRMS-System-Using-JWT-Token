package com.example.HRDetails.For.HrService.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.HRDetails.For.HrService.entities.Employee;
import com.example.HRDetails.For.HrService.entities.Hr;
import com.example.HRDetails.For.HrService.repositories.HrRepository;
import com.example.HRDetails.For.HrService.services.HrService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;



@Service
public class HrServiceImpl implements HrService {

    private Logger logger = LoggerFactory.getLogger(Employee.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public HrRepository hrRepository;

    @Override
    public List<Hr> getAllHrs() {
        List<Hr> hrs = hrRepository.findAll();
        for(Hr hr:hrs){
            ArrayList<Employee> forObject = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeByDepartment/"+hr.getDepartment(),ArrayList.class);
            logger.info("{} ",forObject);
            hr.setEmployees(forObject);
        }
        return hrs;
    }

    @Override
    public Hr findByHrEmployeeId(Integer employeeId) {
        Hr hr =  hrRepository.findByEmployeeId(employeeId);
        ArrayList<Employee> forObject = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeByDepartment/"+hr.getDepartment(),ArrayList.class);
        logger.info("{} ",forObject);
        hr.setEmployees(forObject);
        return hr;
    }

    @Override
    public List<Hr> findByHrEmployeeName(String HrName) {
        List<Hr> hrs = hrRepository.findByHrName(HrName);
        for(Hr hr:hrs){
            ArrayList<Employee> forObject = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeByDepartment/"+hr.getDepartment(),ArrayList.class);
            logger.info("{} ",forObject);
            hr.setEmployees(forObject);
        }
        return hrs;
    }

    @Override
    public Hr findByHrDepartment(String department) {
        Hr hrs = hrRepository.findByDepartment(department);
        ArrayList<Employee> forObject = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeByDepartment/"+hrs.getDepartment(),ArrayList.class);
        logger.info("{} ",forObject);
        hrs.setEmployees(forObject);
        return hrs;
    }

    @Override
    public Hr addHr(Hr hr) {
        Employee employee = new Employee();
        employee.setEmployeeId(hr.getEmployeeId());
        employee.setDepartment(hr.getDepartment());
        employee.setEmployeeName(hr.getHrName());
        employee.setStatus("P");
        
        try {
        Employee response = restTemplate.postForObject("http://EMPLOYEE-SERVICE/employee/addEmployee",employee,Employee.class);
        logger.info("Employee added: {}", response);
        if (response != null) {
            logger.info("Employee added: {}", response);
        } else {
            logger.error("Employee not added in Employee service.");
        }
    } catch (RestClientException e) {
        // Handle HTTP request failure, e.g., log an error message.
        logger.error("Failed to add employee: {}", e.getMessage());
        // You may consider throwing an exception or returning an appropriate response here.
    }

        return hrRepository.save(hr);
    }

    @Override
    public Hr updateHr(Hr hr) {
        Hr hrs = hrRepository.findByEmployeeId(hr.getEmployeeId());
        Employee employee = new Employee();
        employee.setEmployeeId(hr.getEmployeeId());
        employee.setDepartment(hr.getDepartment());
        employee.setEmployeeName(hr.getHrName());
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Set the content type to JSON if that's what you're using

        HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);

        // Use RestTemplate.exchange for PUT request
        ResponseEntity<Void> response = restTemplate.exchange(
            "http://EMPLOYEE-SERVICE/employee/updateEmployee/" + hrs.getEmployeeId(),
            HttpMethod.PUT,
            requestEntity,
            Void.class
        );
        logger.info("Employee updated: {}", response);
        if (response != null) {
            logger.info("Employee updated: {}", response);
        } else {
            logger.error("Employee not updated in Employee service.");
        }
        return hrRepository.save(hr);
    }

    @Override
    public String deteleHr(Integer employeeId) {
        Hr dHr = hrRepository.findByEmployeeId(employeeId);
         ResponseEntity<Void> response = restTemplate.exchange("http://EMPLOYEE-SERVICE/employee/deleteEmployee/"+ dHr.getEmployeeId(),HttpMethod.DELETE,null,Void.class);
        logger.info("Employee deleted: {}", response);
        if (response != null) {
            logger.info("Employee deleted: {}", response);
        } else {
            logger.error("Employee not deleted in Employee service.");
        }
    
        String deleted = "Deleted employee "+ dHr.getHrName();
        hrRepository.delete(dHr);
        return deleted;
    }
    
}
