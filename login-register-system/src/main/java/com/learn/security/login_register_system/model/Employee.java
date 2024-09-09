package com.learn.security.login_register_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "employee_email")
    private String employeeEmail;


    private String password;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_mobile_number")
    private String employeeMobileNumber;

}
