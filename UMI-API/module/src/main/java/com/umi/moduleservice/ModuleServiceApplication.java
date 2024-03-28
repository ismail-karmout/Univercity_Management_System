package com.umi.moduleservice;

import com.umi.moduleservice.entities.Module;
import com.umi.moduleservice.entities.ModuleElement;
import com.umi.moduleservice.feign.ProfessorServiceClient;
import com.umi.moduleservice.feign.SemestreServiceClient;
import com.umi.moduleservice.model.Professor;
import com.umi.moduleservice.model.Semestre;
import com.umi.moduleservice.repositories.ModuleElementRepository;
import com.umi.moduleservice.repositories.ModuleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ModuleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleServiceApplication.class, args);
	}

	// @Bean
	// CommandLineRunner start(
	// 		ModuleRepository moduleRepository,
	// 		ModuleElementRepository moduleElementRepository,
	// 		ProfessorServiceClient professorServiceClient,
	// 		SemestreServiceClient semestreServiceClient
	// ){
	// 	return args -> {

	// 		Professor professor = professorServiceClient.getProfessorById(3L);

	// 		Semestre semestre = semestreServiceClient.getSemestreById(1L);

	// 		Module Info = new Module();
	// 		Info.setName("Informatics");
	// 		Info.setSlug("Lorem ipsum.");
	// 		Info.setProfessorId(professor.getId());
	// 		Info.setSemestreId(semestre.getId());
	// 		moduleRepository.save(Info);


	// 		Module Math = new Module();
	// 		Math.setName("Mathematics");
	// 		Math.setSlug("Lorem ipsum.");
	// 		Math.setProfessorId(professor.getId());
	// 		Math.setSemestreId(semestre.getId());
	// 		moduleRepository.save(Math);

	// 		Long professorId  = professor.getId();


	// 		moduleElementRepository.save(new ModuleElement(null, "Lectures", "Informatics lectures",professorId, null, Info, null, null ));
	// 		moduleElementRepository.save(new ModuleElement( null, "Practical work", "Informatics practical work", null, null, Info, null, null ));

	// 		moduleElementRepository.save(new ModuleElement(null, "Lectures", "Math lectures", professorId, null, Math, null, null ));
	// 		moduleElementRepository.save(new ModuleElement(null, "Practical work", "Math practical work",null, null, Math, null, null ));

	// 	};
	}


