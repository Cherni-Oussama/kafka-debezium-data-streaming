package com.example.upstreamapplication.services.impl;

import com.example.upstreamapplication.exceptions.ItemNotFoundException;
import com.example.upstreamapplication.models.Company;
import com.example.upstreamapplication.repositories.CompanyRepository;
import com.example.upstreamapplication.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(UUID companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new ItemNotFoundException("Company Not Found", null, null, HttpStatus.NOT_FOUND));
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
}
