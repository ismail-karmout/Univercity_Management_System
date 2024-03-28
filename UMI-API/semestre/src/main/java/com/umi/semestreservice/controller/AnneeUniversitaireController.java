package com.umi.semestreservice.controller;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.service.AnneeUniversitaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/anneeUniversitaires")
@AllArgsConstructor
public class AnneeUniversitaireController {
    private AnneeUniversitaireService anneeUniversitaireService;

    @PostMapping
    public ResponseEntity<AnneeUniversitaireDto> createAnneeUniversitaire(@RequestBody AnneeUniversitaireDto anneeUniversitaireDto) {
        AnneeUniversitaireDto savedAnnee = anneeUniversitaireService.createAnneeUniversitaire(anneeUniversitaireDto);
        return new ResponseEntity<>(savedAnnee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnneeUniversitaireDto> getAnneeUniversitaireById(@PathVariable("id") Long id){
        AnneeUniversitaireDto anneeUniversitaireDto = anneeUniversitaireService.getAnneeUniversitaireById(id);
        return ResponseEntity.ok(anneeUniversitaireDto);
    }
    @GetMapping
    public ResponseEntity<List<AnneeUniversitaireDto>> getAllAnneesUniversitaires() {
        List<AnneeUniversitaireDto> allAnneesUniversitaires = anneeUniversitaireService.getAllAnneeUniversitaire();
        return ResponseEntity.ok(allAnneesUniversitaires);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AnneeUniversitaireDto> updateAnneeUniversitaire(@PathVariable Long id, @RequestBody AnneeUniversitaireDto updatedAnneeUniversitaireDto) {
        AnneeUniversitaireDto updatedDto = anneeUniversitaireService.updateAnneeUniversitaire(id, updatedAnneeUniversitaireDto);
        return ResponseEntity.ok(updatedDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnneeUniversitaire(@PathVariable Long id) {
        anneeUniversitaireService.deleteAnneeUniversitaire(id);
        return ResponseEntity.noContent().build();
    }

}
