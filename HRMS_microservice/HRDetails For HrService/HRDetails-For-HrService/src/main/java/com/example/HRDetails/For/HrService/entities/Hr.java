package com.example.HRDetails.For.HrService.entities;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "hr")
public class Hr {
    
    @Id
    @Column(name="employeeId")
    private Integer employeeId;

    @Column(name="hrName")
    private String hrName;

    @Column(name="Department",length =15)
    private String department;

    @Transient
    List<Employee> employees = new ArrayList<Employee>();


}
