package com.umi.filiere.filiere.feignClients;

import com.umi.filiere.filiere.models.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "DEPARTMENT-ETABLISSEMENT")
public interface DepartmentServiceClient {

    @GetMapping("/api/departments/{id}")
    Department getDepartmentById(@PathVariable Long id);

    @GetMapping("/api/departments")
    List<Department> getAllDepartments();
}
