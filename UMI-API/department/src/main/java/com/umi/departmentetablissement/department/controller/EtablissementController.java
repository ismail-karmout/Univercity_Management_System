package com.umi.departmentetablissement.department.controller;

import com.umi.departmentetablissement.department.dto.DepartmentDto;
import com.umi.departmentetablissement.department.dto.EtablissementDto;
import com.umi.departmentetablissement.department.service.DepartmentService;
import com.umi.departmentetablissement.department.service.EtablissementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/etablissements")
@CrossOrigin(origins = "http://localhost:4200")
public class EtablissementController {
    private final EtablissementService etablissementService;
    private final DepartmentService departmentService;

    // Build add etablissement Rest api
    @PostMapping
    public ResponseEntity<EtablissementDto>  createEtablissement(@RequestBody EtablissementDto etablissementDto){
        etablissementDto.setCreated_at(LocalDateTime.now());
        etablissementDto.setUpdated_at(LocalDateTime.now());
        EtablissementDto savedEtablissement = etablissementService.createEtablissement(etablissementDto);
        return new ResponseEntity<>(savedEtablissement, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EtablissementDto> getEtablissementById(@PathVariable("id") Long etablissementId){
        EtablissementDto etablissementDto = etablissementService.getEtablissementById(etablissementId);
        return ResponseEntity.ok(etablissementDto);
    }

    @GetMapping
    public ResponseEntity<List<EtablissementDto>> getAllEtablissements(){
        List<EtablissementDto> etablissements =  etablissementService.getAllEtablissements();
        return ResponseEntity.ok(etablissements);
    }

    @PutMapping("{id}")
    public ResponseEntity<EtablissementDto> updateEtablissement(@PathVariable("id") Long etablissementId,@RequestBody EtablissementDto etablissementDto){
        EtablissementDto etablissementDto1 = etablissementService.updateEtablissement(etablissementId, etablissementDto);
        return ResponseEntity.ok(etablissementDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEtablissement(@PathVariable("id") Long etablissementId){
        etablissementService.deleteEtablissement(etablissementId);
        return ResponseEntity.noContent().build();
//        return ResponseEntity.ok("Etablissement has deleted successfully");
    }
}