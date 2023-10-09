package com.example.MessagingService.For.HrService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MessagingServiceForHrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingServiceForHrServiceApplication.class, args);
	}

}
