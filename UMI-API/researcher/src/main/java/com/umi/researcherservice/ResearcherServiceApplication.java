package com.umi.researcherservice;

import com.umi.researcherservice.entity.*;
import com.umi.researcherservice.enums.RoleType;
import com.umi.researcherservice.repository.*;
import com.umi.researcherservice.service.ProfessorRoleService;
import com.umi.researcherservice.service.ProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ResearcherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearcherServiceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner start(PhdStudentRepository phdStudentRepository,
//							PostDocRepository postDocRepository,
//							ProfessorRepository professorRepository,
//							RoleRepository roleRepository,
//							ProfessorRoleRepository professorRoleRepository){
//		return args -> {
//			PhdStudent phdStudent = new PhdStudent();
//			phdStudent.setFirstname("Mickey");
//			phdStudent.setLastname("Mouse");
//			phdStudent.setEmail("mickeymouse@email.com");
//			phdStudent.setPhone("06321545");
//			phdStudentRepository.save(phdStudent);
//
//			PostDoc postDoc = new PostDoc();
//			postDoc.setFirstname("Minnie");
//			postDoc.setLastname("Mouse");
//			postDoc.setEmail("minniemouse@email.com");
//			postDoc.setPhone("06321545");
//			postDocRepository.save(postDoc);
//
//			Professor professor = new Professor();
//			professor.setFirstname("Donald");
//			professor.setLastname("Duck");
//			professor.setSpeciality("Informatique");
//			professor.setEmail("donaldduck@email.com");
//			professor.setPhone("06321545");
//			professorRepository.save(professor);
//
//			Role role = new Role();
//			role.setName("SMI Manager");
//			role.setRoleType(RoleType.RESPONSABILITE);
//			roleRepository.save(role);
//
////			professorRoleRepository.save(new ProfessorRole(null, professor, role, "cne", null, null));
//		};
//	}

}
