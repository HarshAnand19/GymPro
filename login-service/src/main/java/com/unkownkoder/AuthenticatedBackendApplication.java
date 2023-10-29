package com.unkownkoder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticatedBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticatedBackendApplication.class, args);
	}

}
