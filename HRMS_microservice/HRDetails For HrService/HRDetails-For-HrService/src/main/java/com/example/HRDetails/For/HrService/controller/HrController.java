package com.example.HRDetails.For.HrService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRDetails.For.HrService.entities.Employee;
import com.example.HRDetails.For.HrService.entities.Hr;
import com.example.HRDetails.For.HrService.services.HrService;

@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    public HrService hrService;

    private Logger logger = LoggerFactory.getLogger(Employee.class);
    

    @GetMapping(value="/getAllHrs")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrs();
    }

    @GetMapping(value="/getHrById/{hrId}")
    public Hr getEmployeeById(@PathVariable("hrId") int hrId) {
        return hrService.findByHrEmployeeId(hrId);
    }

    @GetMapping(value="/getHrsByName/{HrName}")
    public List<Hr> getHrByName(@PathVariable("HrName") String HrName) {
           return hrService.findByHrEmployeeName(HrName);
    
    }

    @GetMapping(value="/getHrByDepartment/{departmentName}")
    public Hr getHrByDepartment(@PathVariable("departmentName") String departmentName) {
           return hrService.findByHrDepartment(departmentName);
    }
    
    @PostMapping(value = "/addHr")
    public Hr addEmployee(@RequestBody Hr hr) {
        logger.info("HR service - addHr method invoked.");
        return hrService.addHr(hr);
    }

    @PutMapping(value="/updateHr/{hrId}")
    public Hr updateEmployee(@PathVariable(value = "hrId") int hrId,@RequestBody Hr hr) {

            Hr existHr = hrService.findByHrEmployeeId(hrId);
            existHr.setDepartment(hr.getDepartment());
            existHr.setHrName(hr.getHrName());
            existHr.setEmployees(hr.getEmployees());

            Hr updatedHr = hrService.updateHr(existHr);
            return updatedHr;
        
    }
    @DeleteMapping(value="/deleteHr/{hrId}")
    public String deleteEmployee(@PathVariable("hrId") int hrId) {
        return hrService.deteleHr(hrId);
    } 
}
