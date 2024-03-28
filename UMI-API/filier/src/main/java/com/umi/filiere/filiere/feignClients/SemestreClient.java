package com.umi.filiere.filiere.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "semestre-service")
public interface SemestreClient {

    @GetMapping("/api/semestres")
    List<SemestreClient> getAllSemestres();

    @GetMapping("/api/filiere/{id}")
    SemestreClient getSemestreById(@PathVariable Long id);


}
