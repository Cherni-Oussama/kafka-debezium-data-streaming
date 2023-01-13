package com.example.upstreamapplication.controllers;


import com.example.upstreamapplication.models.dtos.CompanyDTO;
import com.example.upstreamapplication.models.entities.Company;
import com.example.upstreamapplication.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping("")
    public ResponseEntity<Company> addCompany(@RequestBody CompanyDTO company){
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @GetMapping("{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("companyId") UUID companyId){
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @PutMapping("{companyId}")
    public ResponseEntity<Company> updateCompanyById(@PathVariable("companyId") UUID companyId,
                                                     @RequestBody CompanyDTO companyDTO){
        return ResponseEntity.ok(companyService.updateCompanyById(companyId,companyDTO));
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<Company> deleteCompanyById(@PathVariable("companyId") UUID companyId){
        return ResponseEntity.ok(companyService.deleteCompanyById(companyId));
    }

}
