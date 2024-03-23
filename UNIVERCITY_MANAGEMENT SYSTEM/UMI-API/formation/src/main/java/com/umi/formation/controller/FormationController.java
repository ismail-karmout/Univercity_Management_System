package com.umi.formation.controller;
import com.umi.formation.dto.FormationDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.umi.formation.service.FormationService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/formations")
@AllArgsConstructor

public class FormationController {
    private FormationService formationService;

    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        List<FormationDTO> formations = formationService.getAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Long id) {
        FormationDTO formation = formationService.getFormationById(id);
        return new ResponseEntity<>(formation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FormationDTO> addFormation(@RequestBody FormationDTO formationDTO) {
        FormationDTO nouvelleFormation = formationService.addFormation(formationDTO);
        return new ResponseEntity<>(nouvelleFormation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Long id, @RequestBody FormationDTO formationDTO) {
        FormationDTO formationMiseAJour = formationService.updateFormation(id, formationDTO);
        return new ResponseEntity<>(formationMiseAJour, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


