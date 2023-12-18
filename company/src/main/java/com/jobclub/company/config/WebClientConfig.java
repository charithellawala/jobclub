package com.jobclub.company.config;

import com.jobclub.company.client.JobPostClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

//@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;


    @Bean
    public WebClient jobPostWebClient() {
        return WebClient.builder()
                .baseUrl("http://jobPost")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public JobPostClient jobPostClient() {
        HttpServiceProxyFactory httpServiceProxyFactory;
//                = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(jobPostWebClient()))
//               .build();
        //return httpServiceProxyFactory.createClient(JobPostClient.class);
        return null;
    }
}
