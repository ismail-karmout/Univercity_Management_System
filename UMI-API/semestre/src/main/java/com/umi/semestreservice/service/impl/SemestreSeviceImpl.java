package com.umi.semestreservice.service.impl;

import com.umi.semestreservice.dto.SemestreDto;
import com.umi.semestreservice.entity.AnneeUniversitaire;
import com.umi.semestreservice.entity.Semestre;
import com.umi.semestreservice.exception.ResourceNotFoundException;
import com.umi.semestreservice.feignClient.FiliereClient;
import com.umi.semestreservice.mapper.SemestreMapper;
import com.umi.semestreservice.models.Filiere;
import com.umi.semestreservice.repository.AnneeUniversitaireRepository;
import com.umi.semestreservice.repository.SemestreRepository;
import com.umi.semestreservice.service.SemestreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class SemestreSeviceImpl implements SemestreService {

//    private final FiliereClient filiereClient;
    private final SemestreRepository semestreRepository;
    private final AnneeUniversitaireRepository anneeUniversitaireRepository;

    @Override
    public SemestreDto createSemestre(SemestreDto semestreDto) {

        Semestre newSemestre = new Semestre();
        // Attribution des valeurs des attributs à partir du DTO
        newSemestre.setName(semestreDto.getName());
        newSemestre.setIdAcademicYear(semestreDto.getIdAcademicYear());
        newSemestre.setSession(semestreDto.getSession());
        newSemestre.setTypeSession(semestreDto.getTypeSession());
        newSemestre.setIdFiliere(semestreDto.getIdFiliere());

        // Définition de la date de création et de mise à jour
        LocalDateTime now = LocalDateTime.now();
        newSemestre.setCreatedAt(now);
        newSemestre.setUpdatedAt(now);

        // Enregistrement du nouveau semestre dans la base de données
        Semestre createdSemestre = semestreRepository.save(newSemestre);

        // Conversion de l'objet créé en DTO et renvoi
        return SemestreMapper.mapToSemestreDto(createdSemestre);
    }




    @Override
    public SemestreDto updateSemestre(Long id, SemestreDto updatedSemestreDto) {
        // Recherche de semestre à mettre à jour
        Optional<Semestre> semestreOptional = semestreRepository.findById(id);

        // Vérifier si le semestre existe
        if (semestreOptional.isEmpty()) {
            throw new RuntimeException("semestre est introuvable avec l'ID : " + id);
        }

        // Récupérer l'année universitaire à mettre à jour
        Semestre semestre = semestreOptional.get();
        // Mise à jour les attributs de la classe Semestre
        semestre.setName(updatedSemestreDto.getName());
        semestre.setIdAcademicYear(updatedSemestreDto.getIdAcademicYear());
        semestre.setSession(updatedSemestreDto.getSession());
        semestre.setTypeSession(updatedSemestreDto.getTypeSession());
        semestre.setIdFiliere(updatedSemestreDto.getIdFiliere());
        // Mettre à jour la date de mise à jour
        semestre.setUpdatedAt(LocalDateTime.now());
        // Enregistrer les modifications dans la base de données
        Semestre updatedSemestre = semestreRepository.save(semestre);

        // Mapper l'objet mis à jour vers un DTO et le renvoyer
        return SemestreMapper.mapToSemestreDto(updatedSemestre);
    }
    @Override
    public SemestreDto getSemestreById(Long id) {
        Semestre semestre = semestreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found with id: " + id));

        return SemestreMapper.mapToSemestreDto(semestre);
    }

    @Override
    public List<SemestreDto> getAllSemestre() {
        List<Semestre> semestres = semestreRepository.findAll();
        return SemestreMapper.mapToSemestreDtoList(semestres);

    }

    @Override
    public void deleteSemestre(Long id) {
        if (!semestreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Semester is not existing with given id : " + id);
        }
        semestreRepository.deleteById(id);

    }

}
