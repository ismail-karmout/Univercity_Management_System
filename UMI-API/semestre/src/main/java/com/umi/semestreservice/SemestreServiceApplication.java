package com.umi.semestreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages = {"com.umi.semestreservice", "com.umi.semestreservice.feignClient"})

public class SemestreServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(SemestreServiceApplication.class, args);
		System.out.println("-----------------------------------------------\n"+
				"Annee Universitaire-Semestre service is lanced on port 9009\n"+
				"------------------------------------------------------");
	}

}
