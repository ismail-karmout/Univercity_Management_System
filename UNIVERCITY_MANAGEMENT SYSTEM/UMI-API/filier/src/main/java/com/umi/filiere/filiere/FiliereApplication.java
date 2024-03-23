package com.umi.filiere.filiere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class FiliereApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiliereApplication.class, args);
		System.out.println("-----------------------------------------------\n"+
				"Annee Filiere service is lanced on port 9006\n"+
				"------------------------------------------------------");
	}

}
