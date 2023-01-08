package com.example.upstreamapplication.services;

import com.example.upstreamapplication.models.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(UUID companyId);

    Company addCompany(Company company);


}
