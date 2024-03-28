package com.umi.planingexamservice.feign;
import com.umi.planingexamservice.model.Semestre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "semestre-service")
public interface SemestreServiceClient {
    @GetMapping("/api/semestres/{id}")
    Semestre getSemestreById(@PathVariable("id") Long semestreId);

}
