package com.jobclub.company.serviceImpl;

import com.jobclub.company.dao.CompanyDao;
import com.jobclub.company.model.Company;
import com.jobclub.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public Optional<Company> getCompanyById(String id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyDao.saveCompany(company);
    }

    @Override
    public void deleteCompany(String id) {
        companyDao.deleteCompany(id);

    }
}
