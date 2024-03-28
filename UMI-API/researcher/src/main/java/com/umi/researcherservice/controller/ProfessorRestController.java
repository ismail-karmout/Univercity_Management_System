package com.umi.researcherservice.controller;

import com.umi.researcherservice.dto.ProfessorDto;
import com.umi.researcherservice.entity.Professor;
import com.umi.researcherservice.entity.ProfessorRole;
import com.umi.researcherservice.service.ProfessorRoleService;
import com.umi.researcherservice.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ProfessorRestController {
    private ProfessorService professorService;
    private ProfessorRoleService professorRoleService;
    @PostMapping
    ResponseEntity<ProfessorDto> createProfessor(@RequestBody ProfessorDto professorDto){
        ProfessorDto createdProfessor = professorService.createProfessor(professorDto);
        return new ResponseEntity<>(createdProfessor, HttpStatus.CREATED);
    }


    @PostMapping("{userId}/assign-role/{roleId}")
    ResponseEntity<String> assignRoleToProfessor(
            @PathVariable("userId") Long userId,
            @PathVariable("roleId") Long roleId,
            @RequestParam String proof)
    {
        professorRoleService.AddProfessorRole(userId, roleId, proof);
        return ResponseEntity.ok("Role assigned successfully");
    }

    @GetMapping("{id}")
    ResponseEntity<ProfessorDto> getProfessorById(@PathVariable("id") Long professorId){
        ProfessorDto professorDto = professorService.getProfessorById(professorId);
        return ResponseEntity.ok(professorDto);
    }

    @GetMapping
    ResponseEntity<List<ProfessorDto>> getAllProfessor(){
        List<ProfessorDto> professors = professorService.getAllProfessor();
        return ResponseEntity.ok(professors);
    }

    @PutMapping("{id}")
    ResponseEntity<ProfessorDto> updateProfessor(@PathVariable("id") Long id, @RequestBody ProfessorDto updatedProfessor){
        ProfessorDto professorUpdated = professorService.updateProfessor(id, updatedProfessor);
        return ResponseEntity.ok(professorUpdated);
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteProfessor(@PathVariable("id") Long id){
        professorService.deleteProfessor(id);
        return ResponseEntity.ok("Professor is deleted successfully");
    }

}
