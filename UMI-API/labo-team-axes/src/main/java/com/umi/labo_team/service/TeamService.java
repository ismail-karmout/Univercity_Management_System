package com.umi.labo_team.service;

import com.umi.labo_team.dto.TeamDto;
import com.umi.labo_team.model.Department;

import java.util.List;

public interface TeamService {
    TeamDto createTeam(TeamDto teamDto);
    TeamDto getTeamById(Long teamId);
    List<TeamDto> getAllTeams();
    TeamDto updateTeam(Long teamId, TeamDto updateTeam);
    void deleteTeam(Long teamId);

    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
}
