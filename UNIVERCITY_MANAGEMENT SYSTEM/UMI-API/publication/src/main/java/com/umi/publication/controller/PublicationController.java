package com.umi.publication.controller;
import com.umi.publication.dto.PublicationDTO;
import com.umi.publication.entity.Publication;
import com.umi.publication.exception.PublicationNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.umi.publication.service.PublicationService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/publications")
@AllArgsConstructor

public class PublicationController {
    private PublicationService publicationService;

    @GetMapping
    public ResponseEntity<List<PublicationDTO>> getAllPublications() {
        List<PublicationDTO> publications = publicationService.getAllPublications();
        return new ResponseEntity<>(publications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> getPublicationById(@PathVariable Long id) {
        PublicationDTO publication = publicationService.getPublicationById(id);
        return new ResponseEntity<>(publication, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PublicationDTO> addPublication(@RequestBody PublicationDTO publicationDTO) {
        PublicationDTO nouvellePublication = publicationService.addPublication(publicationDTO);
        return new ResponseEntity<>(nouvellePublication, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO> updatePublication(@PathVariable Long id, @RequestBody PublicationDTO publicationDTO) {
        PublicationDTO publicationMiseAJour = publicationService.updatePublication(id, publicationDTO);
        return new ResponseEntity<>(publicationMiseAJour, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        publicationService.deletePublication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/annee/{anneeId}")
    public ResponseEntity<PublicationDTO> getPublicationByAnnee(@PathVariable Long anneeId) {
        try {
            PublicationDTO publication = publicationService.getPublicationByAnnee(anneeId);
            return new ResponseEntity<>(publication, HttpStatus.OK);
        } catch (PublicationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/equipe/{equipeId}")
    public ResponseEntity<PublicationDTO> getPublicationByEquipe(@PathVariable Long equipeId) {
        try {
            PublicationDTO publication = publicationService.getPublicationByEquipe(equipeId);
            return new ResponseEntity<>(publication, HttpStatus.OK);
        } catch (PublicationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/auteur/{auteurId}")
    public ResponseEntity<PublicationDTO> getPublicationByAuteur(@PathVariable Long auteurId) {
        try {
            PublicationDTO publication = publicationService.getPublicationByAuteur(auteurId);
            return new ResponseEntity<>(publication, HttpStatus.OK);
        } catch (PublicationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/labo/{laboId}")
    public ResponseEntity<PublicationDTO> getPublicationByLabo(@PathVariable Long laboId) {
        try {
            PublicationDTO publication = publicationService.getPublicationByLabo(laboId);
            return new ResponseEntity<>(publication, HttpStatus.OK);
        } catch (PublicationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


