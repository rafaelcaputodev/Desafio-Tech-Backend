package com.caputo.DesafioTechBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioTechBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTechBackendApplication.class, args);
	}

}
