package com.umi.researcherservice.mapper;

import com.umi.researcherservice.dto.ResearcherDto;
import com.umi.researcherservice.entity.Researcher;

public class ResearcherMapper {
    public static ResearcherDto mapToResearcherDto(Researcher researcher){
        return new ResearcherDto(
                researcher.getId(),
                researcher.getFirstname(),
                researcher.getLastname(),
                researcher.getEmail(),
                researcher.getPhone(),
                researcher.getLaboId(),
                researcher.getLabo(),
                researcher.getTeamId(),
                researcher.getTeam(),
                researcher.getCreated_at(),
                researcher.getUpdated_at()
        );
    }
}
