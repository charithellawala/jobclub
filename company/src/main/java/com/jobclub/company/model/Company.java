package com.jobclub.company.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Builder
@Document(collection = "company")
public class Company {
    private String id;
    private String name;
    private String location;
    private JobPost employee_title;




    
}
