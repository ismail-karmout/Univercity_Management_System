package com.umi.labo_team.mapper;

import com.umi.labo_team.dto.TeamDto;
import com.umi.labo_team.entity.Team;

public class TeamMapper {
    public static TeamDto mapToTeamDto(Team team){

        return new TeamDto(
                team.getId(),
                team.getTitle(),
                team.getSlug(),
                team.getCreatedAt(),
                team.getUpdatedAt(),
                team.getDeletedAt(),
                team.getLabo(),
//                team.getLabo_id(),
                team.getRechercheAxes(),
                team.getDepartment(),
                team.getDepartment_id()

                );
    }

    public static Team mapToTeam(TeamDto teamDto){
        return new Team(
                teamDto.getId(),
                teamDto.getTitle(),
                teamDto.getSlug(),
                teamDto.getCreated_at(),
                teamDto.getUpdated_at(),
                teamDto.getDeleted_at(),
                teamDto.getDepartment_id(),
                teamDto.getDepartment(),
//                teamDto.getLabo_id(),
                teamDto.getLabo(),
                teamDto.getRechercheAxes()
        );
    }
}
