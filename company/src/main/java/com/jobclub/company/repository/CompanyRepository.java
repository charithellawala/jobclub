package com.jobclub.company.repository;

import com.jobclub.company.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company,String> {

}
