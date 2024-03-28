package com.umi.semestreservice.feignClient;

import com.umi.semestreservice.models.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@FeignClient(name = "filiere-service")

public interface FiliereClient {

    @GetMapping("/api/filiere")
    List<Filiere> getAllFilieres();


    @GetMapping("/api/filiere/{id}")
    Filiere getFiliereById(@PathVariable Long id);


}
