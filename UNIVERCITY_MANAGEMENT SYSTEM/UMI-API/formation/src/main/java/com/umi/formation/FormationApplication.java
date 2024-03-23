package com.umi.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FormationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
		System.out.println("-----------------------------------------------\n" +
				"Annee Filiere service is lanced on port 9004\n" +
				"------------------------------------------------------");
	}

}
