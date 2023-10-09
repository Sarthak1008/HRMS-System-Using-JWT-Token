package com.example.HRDetails.For.HrService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HrDetailsForHrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrDetailsForHrServiceApplication.class, args);
	}

}
