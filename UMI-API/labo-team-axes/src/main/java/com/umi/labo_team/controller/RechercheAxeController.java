package com.umi.labo_team.controller;

import com.umi.labo_team.dto.RechercheAxeDto;
import com.umi.labo_team.service.RechercheAxeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/recherche-axes")
public class RechercheAxeController {
    private RechercheAxeService rechercheAxeService;

    // Build add department Rest api
    @PostMapping
    public ResponseEntity<RechercheAxeDto> createRechercheAxe(@RequestBody RechercheAxeDto rechercheAxeDto) {
        rechercheAxeDto.setCreated_at(LocalDateTime.now());
        rechercheAxeDto.setUpdated_at(LocalDateTime.now());
        RechercheAxeDto savedRechercheAxe = rechercheAxeService.createRechercheAxe(rechercheAxeDto);
        return new ResponseEntity<>(savedRechercheAxe, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RechercheAxeDto> getRechercheAxeById(@PathVariable("id") Long rechercheAxeId){
        RechercheAxeDto rechercheAxeDto = rechercheAxeService.getRechercheAxeById(rechercheAxeId);
        return ResponseEntity.ok(rechercheAxeDto);
    }

    @GetMapping
    public ResponseEntity<List<RechercheAxeDto>> getAllRechercheAxes(){
      List<RechercheAxeDto> rechercheAxes =  rechercheAxeService.getAllRechercheAxes();
        return ResponseEntity.ok(rechercheAxes);
    }

    @PutMapping("{id}")
    public ResponseEntity<RechercheAxeDto> updateRechercheAxe(@PathVariable("id") Long rechercheAxeId, @RequestBody RechercheAxeDto rechercheAxeDto){
        RechercheAxeDto rechercheAxeDto1 = rechercheAxeService.updateRechercheAxe(rechercheAxeId, rechercheAxeDto);
        return ResponseEntity.ok(rechercheAxeDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRechercheAxe(@PathVariable("id") Long rechercheAxeId){
        rechercheAxeService.deleteRechercheAxe(rechercheAxeId);
//        return ResponseEntity.ok("Recherche Axe has deleted successfully");
        return ResponseEntity.noContent().build();
    }

}