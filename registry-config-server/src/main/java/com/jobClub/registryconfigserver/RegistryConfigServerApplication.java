package com.jobClub.registryconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryConfigServerApplication.class, args);
	}

}
