package com.example.backend.dto;

import com.example.backend.model.Company;
import lombok.Data;


@Data
public class WorkerCreateDTO {
    private String firstName;

    private String lastName;

    private Company company;
}
