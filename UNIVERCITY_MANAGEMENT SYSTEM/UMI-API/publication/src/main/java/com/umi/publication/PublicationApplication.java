package com.umi.publication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PublicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicationApplication.class, args);


		System.out.println("-----------------------------------------------\n" +
				"Publication service is lanced on port 9015\n" +
				"------------------------------------------------------");
	}

}
