package com.example.MessagingService.For.HrService.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "message")
public class Message {

    @Id
    @Column(name="messages",length = 200)
    private String messages;
    
    @Column(name="hrId")
    private Integer hrId;

    @Transient 
    Hr hr = new Hr();

    @Column(name="employeeId")
    private Integer employeeId;

    @Transient
    private Employee employee = new Employee();


}
