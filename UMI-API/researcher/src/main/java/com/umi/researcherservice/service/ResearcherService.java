package com.umi.researcherservice.service;

import com.umi.researcherservice.dto.ResearcherDto;

import java.util.List;

public interface ResearcherService {
    ResearcherDto getResearcherById(Long id);
    List<ResearcherDto> getAllResearchers();
}
