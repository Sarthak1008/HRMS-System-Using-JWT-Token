package com.example.demo.entities;

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
@Table(name = "employee")
public class Employee {
    
    @Id
    @Column(name="employeeId")
    private Integer employeeId;

    @Column(name="employeeName")
    private String employeeName;

    @Column(name="Department",length =15)
    private String department;

    @Column(name="status",length = 1)
    private String status;

}
