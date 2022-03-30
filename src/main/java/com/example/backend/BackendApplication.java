package com.example.backend;

import com.example.backend.dto.CompanyCreateDTO;
import com.example.backend.dto.WorkerCreateDTO;
import com.example.backend.model.Company;
import com.example.backend.workerService.CompanyService;
import com.example.backend.workerService.WorkerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialCompany(CompanyService companyService,WorkerService workerService){
		return (args -> {
			CompanyCreateDTO company = new CompanyCreateDTO();
			company.setCompanyName("Enoca");
			company.setDepartmentName("Software");

			companyService.createCompany(company);

		});
	}



}
