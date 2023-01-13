package com.example.upstreamapplication.services;

import com.example.upstreamapplication.models.dtos.CompanyDTO;
import com.example.upstreamapplication.models.entities.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(UUID companyId);

    Company addCompany(CompanyDTO company);

    Company updateCompanyById(UUID companyId, CompanyDTO companyDTO);

    Company deleteCompanyById(UUID companyId);
}
