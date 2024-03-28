package com.umi.moduleservice.feign;

import com.umi.moduleservice.model.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "researcher-service")
public interface ProfessorServiceClient {
    @GetMapping("/api/professors/{id}")
    Professor getProfessorById(@PathVariable("id") Long professorId);
}
