package com.jobclub.company.client;

import com.jobclub.company.model.JobPost;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface JobPostClient {

    @GetExchange("jobPost/company/{companyId}")
    public List<JobPost> findByCompany(@PathVariable("companyId") String companyId);

}
