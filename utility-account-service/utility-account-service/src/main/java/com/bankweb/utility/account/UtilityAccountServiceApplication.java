package com.bankweb.utility.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UtilityAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilityAccountServiceApplication.class, args);
	}

}
