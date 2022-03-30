package com.example.backend.workerService;

import com.example.backend.dto.CompanyCreateDTO;
import com.example.backend.dto.CompanyViewDTO;
import com.example.backend.model.Company;
import com.example.backend.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService{
    private final CompanyRepository companyRepository;
    @Override
    public CompanyViewDTO createCompany(CompanyCreateDTO companyCreateDTO) {
        final Company company=companyRepository.save(new Company(companyCreateDTO.getCompanyName(),
                    companyCreateDTO.getDepartmentName()));
        return CompanyViewDTO.of(company);
        }
    }

