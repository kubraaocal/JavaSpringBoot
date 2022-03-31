package com.example.backend.dto;

import com.example.backend.model.Company;
import lombok.Getter;


import java.io.Serializable;

@Getter
public final class CompanyViewDTO implements Serializable {
    private static  final long serialVersionUID = 1L;

    private final String companyName;

    private final String departmentName;


    private CompanyViewDTO(String companyName, String departmentName) {
        this.companyName = companyName;
        this.departmentName = departmentName;
    }

    public  static CompanyViewDTO of(Company company){
        return new CompanyViewDTO(company.getCompany(),company.getDepartment());
    }
}
