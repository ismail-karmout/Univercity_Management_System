package com.umi.event.event.clients;

import com.umi.event.event.model.Department;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "DEPARTMENT-ETABLISSEMENT-SERVICE")
public interface DepartmentRestClient {

    @GetMapping("/api/departments/{id}")
    @CircuitBreaker(name="departmentService" , fallbackMethod = "getDefaultDepartment")
    Department getDepartmentById(@PathVariable Long id);

    @CircuitBreaker(name="departmentService" , fallbackMethod = "getAllDepartments")
    @GetMapping("/api/departments")
    List<Department> getAllDepartments();

    default Department getDefaultDepartment(Long id , Exception exception){
        Department department=new Department();
        department.setId(id);
        department.setName(" Not Available ");
        department.setDescription(" Not Available ");
        department.setSlug(" Not Available ");
        return department;
    }

    default List<Department> getAllDepartments(Exception exception){
        return List.of();

    }
}
