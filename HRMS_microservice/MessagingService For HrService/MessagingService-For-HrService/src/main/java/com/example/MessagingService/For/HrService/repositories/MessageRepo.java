package com.example.MessagingService.For.HrService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MessagingService.For.HrService.Entities.Message;
import java.util.List;


public interface MessageRepo extends JpaRepository<Message,Integer>{

    List<Message> findByHrId(Integer hrId);
    List<Message> findByEmployeeId(Integer employeeId);

}
    

