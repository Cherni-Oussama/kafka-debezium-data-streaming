package com.example.upstreamapplication.controllers;


import com.example.upstreamapplication.models.Company;
import com.example.upstreamapplication.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/all")
    private ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping("")
    private ResponseEntity<Company> addCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @GetMapping("{companyId}")
    private ResponseEntity<Company> getCOmpanyById(@PathVariable("companyId") UUID companyId){
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }
}
