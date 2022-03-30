package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="companys")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="company_name", nullable = false)
    private String company;

    @Column(name = "department_name",nullable = false)
    private String department;


    public Company(String company, String department) {
        this.company = company;
        this.department = department;
    }
}
