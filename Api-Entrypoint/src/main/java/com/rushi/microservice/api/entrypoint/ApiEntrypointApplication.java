package com.rushi.microservice.api.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiEntrypointApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEntrypointApplication.class, args);
	}

}
