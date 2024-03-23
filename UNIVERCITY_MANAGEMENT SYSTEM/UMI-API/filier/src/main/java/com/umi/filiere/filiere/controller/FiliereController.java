package com.umi.filiere.filiere.controller;
import com.umi.filiere.filiere.dto.FiliereDto;
import com.umi.filiere.filiere.entity.Filiere;
import com.umi.filiere.filiere.feignClients.DepartmentServiceClient;
import com.umi.filiere.filiere.models.Department;
import com.umi.filiere.filiere.service.FiliereService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/filiere")
@AllArgsConstructor
public class FiliereController {
    private FiliereService filiereService;
    private DepartmentServiceClient departmentServiceClient;


    @GetMapping
    public ResponseEntity<List<FiliereDto>> getAllFilieres() {
        List<FiliereDto> filieres = filiereService.getAllFilieres();
        return new ResponseEntity<>(filieres, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FiliereDto> getFiliereById(@PathVariable Long id) {
        FiliereDto filiere = filiereService.getFiliereById(id);
        Department department=departmentServiceClient.getDepartmentById(filiere.getDepartment_id());
        filiere.setDepartment(department);
        return new ResponseEntity<>(filiere, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<FiliereDto> addFiliere(@RequestBody FiliereDto filiereDTO) {
        FiliereDto nouvelleFiliere = filiereService.addFiliere(filiereDTO);
        return new ResponseEntity<>(nouvelleFiliere, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiliereDto> updateFiliere(@PathVariable Long id, @RequestBody FiliereDto filiereDTO) {
        FiliereDto filiereMiseAJour = filiereService.updateFiliere(id, filiereDTO);
        return new ResponseEntity<>(filiereMiseAJour, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
