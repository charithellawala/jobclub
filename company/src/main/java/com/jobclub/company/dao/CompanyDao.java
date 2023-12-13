package com.jobclub.company.dao;

import com.jobclub.company.model.Company;
import com.jobclub.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyDao {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(String id) {
        return companyRepository.findById(id);
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(String id) {
        companyRepository.deleteById(id);
    }
}
