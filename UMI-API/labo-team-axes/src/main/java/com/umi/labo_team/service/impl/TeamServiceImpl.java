package com.umi.labo_team.service.impl;


import com.umi.labo_team.dto.TeamDto;
import com.umi.labo_team.entity.Team;
import com.umi.labo_team.exception.ResourceNotFoundException;
import com.umi.labo_team.feign.DepartmentServiceClient;
import com.umi.labo_team.mapper.LaboMapper;
import com.umi.labo_team.mapper.TeamMapper;
import com.umi.labo_team.model.Department;
import com.umi.labo_team.repository.TeamRepository;
import com.umi.labo_team.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final DepartmentServiceClient departmentServiceClient;

    @Override
    public TeamDto createTeam(TeamDto departmentDto) {
        Team team = TeamMapper.mapToTeam(departmentDto);
        Team savedTeam = teamRepository.save(team);
        return TeamMapper.mapToTeamDto(savedTeam);
    }

    @Override
    public TeamDto getTeamById(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("The department is not exist with the given id: " + teamId));
        return TeamMapper.mapToTeamDto(team);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(TeamMapper::mapToTeamDto).collect(Collectors.toList());
//        return teams.stream().map((team) -> TeamMapper.mapToTeamDto(team)).collect(Collectors.toList());
    }
    @Override
    public Department getDepartmentById(Long id) {
        return departmentServiceClient.getDepartmentById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentServiceClient.getAllDepartments();
    }

    @Override
    public TeamDto updateTeam(Long teamId, TeamDto updateTeam) {
        Team department = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + teamId));
        if (updateTeam.getTitle() != null)
            department.setTitle(updateTeam.getTitle());
        if (updateTeam.getSlug() != null)
            department.setSlug(updateTeam.getSlug());
        if (updateTeam.getRechercheAxes() != null)
            department.setRechercheAxes(updateTeam.getLabo().getRechercheAxes());
        if (updateTeam.getLabo() != null)
            department.setLabo(updateTeam.getLabo());
        department.setUpdatedAt(LocalDateTime.now());
        Team updatedDepartmentObj = teamRepository.save(department);
        return TeamMapper.mapToTeamDto(updatedDepartmentObj);
    }

    @Override
    public void deleteTeam(Long teamId) {
        Team department = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + teamId));
        teamRepository.deleteById(teamId);

    }
}
