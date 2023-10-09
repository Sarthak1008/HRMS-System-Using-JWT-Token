package com.example.HRDetails.For.HrService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRDetails.For.HrService.entities.Hr;
import java.util.List;


public interface HrRepository extends JpaRepository<Hr,Integer> {
    Hr findByEmployeeId(Integer employeeId);
    List<Hr> findByHrName(String hrName);
    Hr findByDepartment(String department);
}
