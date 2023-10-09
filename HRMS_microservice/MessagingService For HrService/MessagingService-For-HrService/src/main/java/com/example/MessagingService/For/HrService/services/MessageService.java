package com.example.MessagingService.For.HrService.services;

import java.util.List;

import com.example.MessagingService.For.HrService.Entities.Message;

public interface MessageService {
    List<Message> getAllMessages();
    List<Message> findByhrId(Integer hrId);
    List<Message> findByemployeeId(Integer employeeId);
    Message addMessage(Message message);
    Message updateMessage(Message message);
    String deteleMessage(Integer hrId, String message);
}
