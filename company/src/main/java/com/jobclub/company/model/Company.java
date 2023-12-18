package com.jobclub.company.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@Document(collection = "company")
public class Company {
    private String id;
    private String name;
    private String location;
    private List<JobPost> jobVacancy = new ArrayList<>();

   // private JobPost employee_title;




    
}
