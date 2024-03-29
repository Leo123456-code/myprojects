package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Sp005RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp005RibbonApplication.class, args);
	}

}
