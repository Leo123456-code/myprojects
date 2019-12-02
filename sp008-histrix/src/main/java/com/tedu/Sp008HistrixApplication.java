package com.tedu;

import java.beans.Transient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
public class Sp008HistrixApplication {

	@Transient
	public static void main(String[] args) {
		SpringApplication.run(Sp008HistrixApplication.class, args);
	}

}
