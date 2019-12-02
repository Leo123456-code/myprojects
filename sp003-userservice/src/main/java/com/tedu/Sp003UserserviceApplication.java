package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class Sp003UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp003UserserviceApplication.class, args);
	}

}
