package com.stackroute.chattingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// @EnableDiscoveryClient
public class ChattingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChattingServiceApplication.class, args);
	}

}
