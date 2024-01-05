package com.jobclub.company.controller;

import com.jobclub.company.client.JobPostClient;
import com.jobclub.company.model.Company;
import com.jobclub.company.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobPostClient jobPostClient;

    private static final Logger LOGGER
            = LoggerFactory.getLogger(CompanyController.class);

    @GetMapping
    public List<Company> getAllCompanies() {
        LOGGER.info("All registered companies");
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Company> saveUser(@RequestBody Company company) {
        Company savedUser = companyService.saveCompany(company);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateUser(@PathVariable String id, @RequestBody Company company) {
        Optional<Company> existingUser = companyService.getCompanyById(id);

        if (existingUser.isPresent()) {
            Company updatedCompany = companyService.saveCompany(company);
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String id) {
        Optional<Company> company = companyService.getCompanyById(id);

        if (company.isPresent()) {
            companyService.deleteCompany(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/with-jobPosts")
    public List<Company> findAllWithAllPostedJobs() {
        LOGGER.info("available vacancy jobs under companies");
        List<Company> companies
                = companyService.getAllCompanies();
        companies.forEach(company ->
                company.setJobVacancy(
                        jobPostClient.findByCompany(company.getId())));
        return companies;
    }


}
