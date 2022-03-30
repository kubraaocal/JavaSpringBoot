package com.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Worker(String firstName, String lastName, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }
}
