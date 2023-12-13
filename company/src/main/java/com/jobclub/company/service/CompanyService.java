package com.jobclub.company.service;

import com.jobclub.company.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> getAllCompanies();

    Optional<Company> getCompanyById(String id);

    Company saveCompany(Company user);

    void deleteCompany(String id);
}
