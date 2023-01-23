package com.example.upstreamapplication.services.impl;

import com.example.upstreamapplication.exceptions.ItemNotFoundException;
import com.example.upstreamapplication.models.dtos.CompanyDTO;
import com.example.upstreamapplication.models.entities.Company;
import com.example.upstreamapplication.repositories.CompanyRepository;
import com.example.upstreamapplication.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(UUID companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new ItemNotFoundException("Company Not Found", null, null, HttpStatus.NOT_FOUND));
    }

    @Override
    public Company addCompany(CompanyDTO company) {

        return companyRepository.save(Company.builder()
                .companyId(UUID.randomUUID())
                        .companyName(company.getCompanyName())
                        .createdAt(LocalDateTime.now())
                        .registeredAt(company.getRegisteredAt())
                        .employeesNumber(company.getEmployeesNumber())
                        .sector(company.getSector())
                .build());
    }

    @Override
    public Company updateCompanyById(UUID companyId, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ItemNotFoundException("Company Not Found", null, null, HttpStatus.NOT_FOUND));
        companyRepository.save(company);
        return company;
    }

    @Override
    public Company deleteCompanyById(UUID companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ItemNotFoundException("Company Not Found", null, null, HttpStatus.NOT_FOUND));
        companyRepository.delete(company);
        return company;
    }

}
