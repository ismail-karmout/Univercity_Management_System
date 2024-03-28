package com.umi.researcherservice.feign;

import com.umi.researcherservice.model.Labo;
import com.umi.researcherservice.model.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "labo-team-axes")
public interface LaboServiceClient {
    @GetMapping("/api/labos/{id}")
    Labo getLaboById(@PathVariable("id") Long id);

    @GetMapping("/api/teams/{id}")
    Team getTeamById(@PathVariable("id") Long teamId);
}
