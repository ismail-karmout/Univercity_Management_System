package com.umi.researcherservice.controller;

import com.umi.researcherservice.dto.ResearcherDto;
import com.umi.researcherservice.service.ResearcherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/researchers")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ResearcherRestController {
    private ResearcherService researcherService;

    @GetMapping("{researcherId}")
    ResponseEntity<ResearcherDto> getResearcherById(@PathVariable Long researcherId){
        ResearcherDto researcherDto = researcherService.getResearcherById(researcherId);
        return ResponseEntity.ok(researcherDto);
    }

    @GetMapping
    ResponseEntity<List<ResearcherDto>> getAllResearchers(){
        List<ResearcherDto> researchers = researcherService.getAllResearchers();
        return ResponseEntity.ok(researchers);
    }
}
