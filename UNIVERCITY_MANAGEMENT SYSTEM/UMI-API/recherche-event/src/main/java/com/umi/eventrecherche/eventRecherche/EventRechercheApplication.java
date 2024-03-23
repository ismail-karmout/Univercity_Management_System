package com.umi.eventrecherche.eventRecherche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EventRechercheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventRechercheApplication.class, args);
	}

}
