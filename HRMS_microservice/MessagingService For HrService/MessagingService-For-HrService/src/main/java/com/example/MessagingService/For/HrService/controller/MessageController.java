package com.example.MessagingService.For.HrService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MessagingService.For.HrService.Entities.Message;
import com.example.MessagingService.For.HrService.services.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    
    @Autowired
    public MessageService messageService;

    @GetMapping(value="/getAllMessages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping(value="/getMessagesByHrId/{hrId}")
    public List<Message> getMessagesByHrId(@PathVariable("hrId") int hrId) {
        return messageService.findByhrId(hrId);
    }

    @GetMapping(value="/getMessagesByEmployeeId/{employeeId}")
    public List<Message> getMessagesByEmployeeId(@PathVariable("employeeId") int employeeId) {
           return messageService.findByemployeeId(employeeId);
    
    }
    
    @PostMapping(value = "/addMessage")
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @PutMapping(value="/updateMessage")
    public Message updateEmployee(@RequestParam Integer hrId,@RequestParam String messaged,@RequestBody Message message) {

            List<Message> existmessage = messageService.findByhrId(hrId);
            for(Message msg:existmessage){
                if(msg.getMessages().equals(messaged)){
                    msg.setMessages(message.getMessages());
                    msg.setEmployeeId(message.getEmployeeId());
                    Message newMessage = messageService.updateMessage(msg);
                    return newMessage;
                }
            }
            return null;
        
    }
    @DeleteMapping(value="/deleteMessage")
    public String deleteMessage(@RequestParam Integer hrId,@RequestParam String message) {
        return messageService.deteleMessage(hrId, message);
    } 
}
