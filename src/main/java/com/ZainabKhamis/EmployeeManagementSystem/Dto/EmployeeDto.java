package com.ZainabKhamis.EmployeeManagementSystem.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private double salary;
    private Date joinDate;
    private String department;
}
