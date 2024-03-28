package com.umi.labo_team.feign;

import com.umi.labo_team.model.EcoleDoctorale;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "ECOLE-DOCTORALE")
public interface EcoleDoctoraleServiceClient {
    @GetMapping("/api/ecole-doctorales/{id}")
    EcoleDoctorale getEcoleDoctoraleById(@PathVariable Long id);

    @GetMapping("/api/ecole-doctorales")
    List<EcoleDoctorale> getAllEcoleDoctorales();
}