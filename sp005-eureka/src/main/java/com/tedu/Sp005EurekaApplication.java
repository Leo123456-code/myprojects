package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Sp005EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp005EurekaApplication.class, args);
	}

}
