package com.example.API.Gateway.Hr.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayHrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayHrServiceApplication.class, args);
	}

}
