package com.umi.recherche.ecoledoctorale.controller;

import com.umi.recherche.ecoledoctorale.dto.EcoleDoctoraleRequestDTO;
import com.umi.recherche.ecoledoctorale.dto.EcoleDoctoraleResponseDTO;
import com.umi.recherche.ecoledoctorale.entity.EcoleDoctorale;
import com.umi.recherche.ecoledoctorale.service.EcoleDoctoraleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ecole-doctorales")
public class EcoleDoctoraleController {
    private EcoleDoctoraleService ecoleDoctoraleService;
    // Get all Ecoles Doctorales
    @GetMapping
    public List<EcoleDoctorale> getEcoleDoctorale(){

        return ecoleDoctoraleService.getAllEcoleDoctorales();
    }
    // Get Ecole Doctorale By Id
    @GetMapping("/{id}")
    public EcoleDoctorale getEcoleDoctoraleById(@PathVariable Long id){
        return ecoleDoctoraleService.getEcoleDoctoraleById(id);
    }
    // Create a new Ecole Doctroale
    @PostMapping
    public ResponseEntity<EcoleDoctoraleResponseDTO> createEcoleDoctorale(@RequestBody EcoleDoctoraleResponseDTO ecoleDoctoraleResponseDTO){
        EcoleDoctoraleResponseDTO savedEcoleDoctorale = ecoleDoctoraleService.createEcoleDoctorale(ecoleDoctoraleResponseDTO);
        return new ResponseEntity<>(savedEcoleDoctorale, HttpStatus.CREATED);
    }
    // Update Ecole Doctorale
    @PutMapping("/{id}")
    public EcoleDoctoraleResponseDTO updateEcoleDoctorale(@PathVariable Long id, @RequestBody EcoleDoctoraleRequestDTO ecoleDoctoraleRequestDTO){
        return ecoleDoctoraleService.updateEcoleDoctorale(id,ecoleDoctoraleRequestDTO);
    }

    // Delete Ecole Doctorale
    @DeleteMapping("/{id}")
    public void deleteEcoleDoctorale(@PathVariable Long id){

        ecoleDoctoraleService.deleteEcoleDoctorale(id);
    }
}
