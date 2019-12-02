package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@EnableCircuitBreaker(服务降级熔断)
//@EnableDiscoveryClient（服务 ）
//@SpringBootApplication
@SpringCloudApplication
public class Sp005RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp005RibbonApplication.class, args);
	}

}
