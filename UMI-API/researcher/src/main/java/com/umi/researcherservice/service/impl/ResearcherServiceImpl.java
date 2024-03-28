package com.umi.researcherservice.service.impl;

import com.umi.researcherservice.dto.ResearcherDto;
import com.umi.researcherservice.entity.Researcher;
import com.umi.researcherservice.exception.ResourceNotFoundException;
import com.umi.researcherservice.mapper.ResearcherMapper;
import com.umi.researcherservice.repository.ResearcherRepository;
import com.umi.researcherservice.service.ResearcherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResearcherServiceImpl implements ResearcherService {
    private ResearcherRepository researcherRepository;
    @Override
    public ResearcherDto getResearcherById(Long id) {
        Researcher researcher = researcherRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Researcher is not exits with given id "+id));
        return ResearcherMapper.mapToResearcherDto(researcher);
    }

    @Override
    public List<ResearcherDto> getAllResearchers() {
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("====== Call of the service    function success ==============");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        List<Researcher> researchers = researcherRepository.findAll();
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        System.out.println("====== Return of the repository function success ==============");
        System.out.println("=============================================================");
        System.out.println("=============================================================");
        return researchers.stream().map((researcher)->ResearcherMapper.mapToResearcherDto(researcher))
                .collect(Collectors.toList());
    }
}
