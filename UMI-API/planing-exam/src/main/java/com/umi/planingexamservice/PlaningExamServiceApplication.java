package com.umi.planingexamservice;

import com.umi.planingexamservice.entities.Exam;
import com.umi.planingexamservice.entities.PlaningExam;
import com.umi.planingexamservice.repositories.ExamRepository;
import com.umi.planingexamservice.repositories.PlaningExamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients

public class PlaningExamServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaningExamServiceApplication.class, args);
	}

	// @Bean
	// CommandLineRunner start(ExamRepository examRepository, PlaningExamRepository planingExamRepository){
	// 	return args -> {
	// 		PlaningExam planingExam = new PlaningExam();
	// 		planingExam.setAvis("This is an avis for exams planing");
	// 		planingExam.setPlaning("This is a planing exam");
	// 		planingExam.setSemestreId(1L);
	// 		planingExamRepository.save(planingExam);

	// 		examRepository.save(new Exam(null,"Chimistry Exam","Chimistry", null, null, null));
	// 		examRepository.save(new Exam(null,"Physics Exam","Physics", planingExam, null, null));
	// 		examRepository.save(new Exam(null,"Maths Exam","Maths", planingExam, null, null));
	// 		examRepository.save(new Exam(null,"Informatics Exam","Informatics", planingExam, null, null));

	// 	};
	// }

}
