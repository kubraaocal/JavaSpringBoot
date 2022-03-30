package com.example.backend.dto;

import com.example.backend.model.Company;
import com.example.backend.model.Worker;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class WorkerViewDTO implements Serializable {
    private static  final long serialVersionUID = 1L;

    private final String firstName;

    private final String lastName;

    private final Company company;

    private WorkerViewDTO(String firstName, String lastName,Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company=company;
    }

    public  static WorkerViewDTO of(Worker worker){
        return new WorkerViewDTO(worker.getFirstName(),worker.getLastName(),worker.getCompany());
    }
}
