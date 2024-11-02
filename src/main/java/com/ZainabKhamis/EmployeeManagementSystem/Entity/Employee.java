package com.ZainabKhamis.EmployeeManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(name="birth_date")
    private Date dateOfBirth;

    @Column(name="salary")
    private double salary;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(name="join_date")
    private Date joinDate;

    @Column(name="department")
    private String department;

}
