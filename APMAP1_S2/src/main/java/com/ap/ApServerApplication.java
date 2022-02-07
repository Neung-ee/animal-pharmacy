package com.ap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApServerApplication.class, args);
	}

}
