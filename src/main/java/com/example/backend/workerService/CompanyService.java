package com.example.backend.workerService;

import com.example.backend.dto.CompanyCreateDTO;
import com.example.backend.dto.CompanyViewDTO;

public interface CompanyService {
    CompanyViewDTO createCompany(CompanyCreateDTO companyCreateDTO);
}
