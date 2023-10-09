package com.example.HRDetails.For.HrService.services;

import java.util.List;

import com.example.HRDetails.For.HrService.entities.Hr;

public interface HrService {
    List<Hr> getAllHrs();
    Hr findByHrEmployeeId(Integer employeeId);
    List<Hr> findByHrEmployeeName(String HrName);
    Hr findByHrDepartment(String department);
    Hr addHr(Hr hr);
    Hr updateHr(Hr hr);
    String deteleHr(Integer employeeId);
}
