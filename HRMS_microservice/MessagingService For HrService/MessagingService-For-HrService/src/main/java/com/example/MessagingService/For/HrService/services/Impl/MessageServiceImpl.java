package com.example.MessagingService.For.HrService.services.Impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.MessagingService.For.HrService.Entities.Employee;
import com.example.MessagingService.For.HrService.Entities.Hr;
import com.example.MessagingService.For.HrService.Entities.Message;
import com.example.MessagingService.For.HrService.repositories.MessageRepo;
import com.example.MessagingService.For.HrService.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    public MessageRepo messageRepo;

    private Logger hrLogger = LoggerFactory.getLogger(Hr.class);
     private Logger employeeLogger = LoggerFactory.getLogger(Employee.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Message> getAllMessages() {
        List<Message> msgs = messageRepo.findAll();
        for(Message m:msgs){
            Hr hr = restTemplate.getForObject("http://HR-SERVICE/hr/getHrById/"+ m.getHrId() ,Hr.class);
            hrLogger.info("{} ",hr);
            m.setHr(hr);
            Employee employee = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeById/"+ m.getEmployeeId() ,Employee.class);
            employeeLogger.info("{} ",employee);
            m.setEmployee(employee);
        }
        return msgs;
    }

    @Override
    public List<Message> findByhrId(Integer hrId) {
        List<Message> msgs = messageRepo.findByHrId(hrId);
        for(Message m:msgs){
            Hr hr = restTemplate.getForObject("http://HR-SERVICE/hr/getHrById/"+ m.getHrId() ,Hr.class);
            hrLogger.info("{} ",hr);
            m.setHr(hr);
            Employee employee = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeById/"+ m.getEmployeeId() ,Employee.class);
            employeeLogger.info("{} ",employee);
            m.setEmployee(employee);
        }
        return msgs;
    }

    @Override
    public List<Message> findByemployeeId(Integer employeeId) {
        List<Message> msgs =  messageRepo.findByEmployeeId(employeeId);
        for(Message m:msgs){
            Hr hr = restTemplate.getForObject("http://HR-SERVICE/hr/getHrById/"+ m.getHrId() ,Hr.class);
            hrLogger.info("{} ",hr);
            m.setHr(hr);
            Employee employee = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeById/"+ m.getEmployeeId() ,Employee.class);
            employeeLogger.info("{} ",employee);
            m.setEmployee(employee);
        }
        return msgs;
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public String deteleMessage(Integer hrId, String message) {
        List<Message> messages = messageRepo.findByHrId(hrId);
        StringBuilder sb = new StringBuilder();
        Message dmsg = new Message();
        for(Message msg: messages){
            if(msg.getMessages().equals(message)){
                dmsg = msg;
                break;
            }
        }
        sb.append("Deleted message " + hrId+": "+ dmsg.getMessages() );
        messageRepo.delete(dmsg);
        return sb.toString();
    }
    
}
