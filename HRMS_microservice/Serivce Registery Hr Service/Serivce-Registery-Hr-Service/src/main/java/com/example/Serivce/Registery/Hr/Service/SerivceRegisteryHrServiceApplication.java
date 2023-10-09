package com.example.Serivce.Registery.Hr.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SerivceRegisteryHrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerivceRegisteryHrServiceApplication.class, args);
	}

}
