package com.umi.studentservice;

import com.umi.studentservice.entity.Student;
import com.umi.studentservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class  StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	// @Bean
	// CommandLineRunner start(StudentRepository repository){
 	// 	return args -> {
	// 		repository.save(new Student(null, "Mickey", "Mouse", "mickeymouse@email.com", "1598dfefe98", "M989scd",null,null));
	// 		repository.save(new Student(null, "Mimi", "Mouse", "minniemouse@email.com", "1598dfefe98", "M989scd",null,null));
	// 		repository.save(new Student(null, "Donald", "Duck", "donaldduck@email.com", "1598dfefe98", "M989scd",null,null));
	// 		repository.save(new Student(null, "Daisy", "Duck", "daisyduck@email.com", "1598dfefe98", "M989scd",null,null));
	// 	};
	// }
}
