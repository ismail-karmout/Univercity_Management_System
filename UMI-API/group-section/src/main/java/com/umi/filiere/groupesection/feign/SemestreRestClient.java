package com.umi.filiere.groupesection.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "SEMESTRE-SERVICE")
public interface SemestreRestClient {
    @GetMapping("/api/semestres")
    List<SemestreRestClient> getAllSemestres();

    @GetMapping("/api/semestres{id}")
    SemestreRestClient getSemestreById(@PathVariable Long id);
}
