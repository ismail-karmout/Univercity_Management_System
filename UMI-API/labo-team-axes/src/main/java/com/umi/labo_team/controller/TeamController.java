package com.umi.labo_team.controller;

import com.umi.labo_team.dto.LaboDto;
import com.umi.labo_team.dto.TeamDto;
import com.umi.labo_team.feign.DepartmentServiceClient;
import com.umi.labo_team.mapper.LaboMapper;
import com.umi.labo_team.model.Department;
import com.umi.labo_team.service.LaboService;
import com.umi.labo_team.service.TeamService;
import com.umi.labo_team.service.impl.LaboServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/teams")
public class TeamController {
    private TeamService teamService;
    private DepartmentServiceClient departmentServiceClient;
    private LaboServiceImpl laboService;


    // Build add department Rest api
    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        teamDto.setCreated_at(LocalDateTime.now());
        teamDto.setUpdated_at(LocalDateTime.now());
        System.out.println("===============================================");
        System.out.println(teamDto.getDepartment_id());
        System.out.println("===============================================");
        System.out.println(teamDto.getLabo());
        System.out.println("===============================================");
        System.out.println(teamDto.getRechercheAxes());

        try {
            TeamDto savedTeam = teamService.createTeam(teamDto);
            return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            // Handle the case where the department_id constraint is violated
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable("id") Long teamId){
        TeamDto teamDto = teamService.getTeamById(teamId);
//        Department department=departmentServiceClient.getDepartmentById(teamDto.getDepartment_id());
//        teamDto.setDepartment(department);
        return ResponseEntity.ok(teamDto);
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams(){
      List<TeamDto> teams =  teamService.getAllTeams();
//        teams.forEach(team->{
//            team.setDepartment(departmentServiceClient.getDepartmentById(team.getDepartment_id()));
//        });
        return ResponseEntity.ok(teams);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable("id") Long departmentId, @RequestBody TeamDto teamDto){
        TeamDto teamDto1 = teamService.updateTeam(departmentId, teamDto);
        return ResponseEntity.ok(teamDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable("id") Long teamId){
        teamService.deleteTeam(teamId);
        return ResponseEntity.noContent().build();
//        return ResponseEntity.ok("Team has deleted successfully");
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        Department department = teamService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = teamService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

}
