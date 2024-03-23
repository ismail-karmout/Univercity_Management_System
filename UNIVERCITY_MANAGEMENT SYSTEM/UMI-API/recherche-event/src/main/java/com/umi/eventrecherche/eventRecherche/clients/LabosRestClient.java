package com.umi.eventrecherche.eventRecherche.clients;


import com.umi.eventrecherche.eventRecherche.model.Labos;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "LABO-TEAM-AXES")
public interface LabosRestClient {

    @GetMapping("/api/labos/{id}")
    @CircuitBreaker(name="labosService" , fallbackMethod = "getDefaultLabos")
    Labos getLabosById(@PathVariable Long id);

    @CircuitBreaker(name="labosService" , fallbackMethod = "getAllLabos")
    @GetMapping("/api/labos")
    List<Labos> getAllLabos();

    default Labos getDefaultLabos(Long id , Exception exception){
        Labos labos=new Labos();
        labos.setId(id);
        labos.setTitle(" Not Available ");
        labos.setAcroname(" Not Available ");
        labos.setSlug(" Not Available ");
        return labos;
    }
    default List<Labos> getAllLabos(Exception exception){
        return List.of();

    }
}
