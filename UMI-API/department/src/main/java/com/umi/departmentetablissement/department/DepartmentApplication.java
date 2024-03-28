package com.umi.departmentetablissement.department;

import com.umi.departmentetablissement.department.controller.DepartmentController;
import com.umi.departmentetablissement.department.dto.DepartmentDto;
import com.umi.departmentetablissement.department.service.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner initData(DepartmentController departmentService) {
//		return args -> {
//			// Create and save an example department when the application starts
//			DepartmentDto exampleDepartment = new DepartmentDto();
//			exampleDepartment.setName("Example 1");
//			exampleDepartment.setDescription("This is an example department 1.");
//			exampleDepartment.setSlug("example-department");
//
//			departmentService.createDepartment(exampleDepartment);
//		};
//	}
}
