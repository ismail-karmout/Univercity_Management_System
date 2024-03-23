package com.umi.semestreservice.controller;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.dto.SemestreDto;
import com.umi.semestreservice.entity.Semestre;
import com.umi.semestreservice.service.AnneeUniversitaireService;
import com.umi.semestreservice.service.SemestreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/semestres")
@AllArgsConstructor
public class SemestreControlleur {
    private SemestreService semestreService;


    @GetMapping("/{id}")
    public ResponseEntity<SemestreDto> getSemestreById(@PathVariable("id") Long id){
        SemestreDto SemestreDto = semestreService.getSemestreById(id);
        return ResponseEntity.ok(SemestreDto);
    }
    @GetMapping
    public ResponseEntity<List<SemestreDto>> getAllSemestres() {
        List<SemestreDto> allSemestres = semestreService.getAllSemestre();
        return ResponseEntity.ok(allSemestres);
    }
    @PostMapping
    public ResponseEntity<SemestreDto> createSemestre(@RequestBody SemestreDto semestreDto) {
        SemestreDto savedSemestre = semestreService.createSemestre(semestreDto);
        return new ResponseEntity<>(savedSemestre, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SemestreDto> updateSemestre(@PathVariable Long id, @RequestBody SemestreDto updatedSemestreDto) {
        SemestreDto updatedDto = semestreService.updateSemestre(id, updatedSemestreDto);
        return ResponseEntity.ok(updatedDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.noContent().build();
    }

}
