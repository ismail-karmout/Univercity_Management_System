package com.umi.filiere.filiere.service.impl;

import com.umi.filiere.filiere.dto.FiliereDto;
import com.umi.filiere.filiere.entity.Filiere;
import com.umi.filiere.filiere.exception.FiliereNotFoundException;
import com.umi.filiere.filiere.feignClients.DepartmentServiceClient;
import com.umi.filiere.filiere.mapper.FiliereMapper;
import com.umi.filiere.filiere.models.Department;
import com.umi.filiere.filiere.repository.FiliereRepository;
import com.umi.filiere.filiere.service.FiliereService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class FiliereServiceImpl implements FiliereService {


    public final FiliereRepository filiereRepository;
    public final DepartmentServiceClient departmentServiceClient;


    @Override
    public List<FiliereDto> getAllFilieres() {
        List<Filiere> filieres = filiereRepository.findAll();
        return FiliereMapper.mapToFiliereDtoList(filieres);
    }

    @Override
    public FiliereDto getFiliereById(Long id) {
        Filiere filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new FiliereNotFoundException("Filiere not found with id: " + id));
        return FiliereMapper.mapToFiliereDto(filiere);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentServiceClient.getDepartmentById(id);
    }

    @Override
    public FiliereDto addFiliere(FiliereDto filiereDto) {
        // Vérifier si une filière avec le même nom existe déjà
        Optional<Filiere> existingFiliere = filiereRepository.findByName(filiereDto.getName());
        if (existingFiliere.isPresent()) {
            throw new  FiliereNotFoundException("Filiere with name: " + filiereDto.getName()+"Already exists");
        }

        Filiere nouvelleFiliere = FiliereMapper.mapToFiliere(filiereDto);
        nouvelleFiliere.setCreatedAt(LocalDateTime.now());
        Filiere savedFiliere = filiereRepository.save(nouvelleFiliere);
        return FiliereMapper.mapToFiliereDto(savedFiliere);
    }

    @Override
    public FiliereDto updateFiliere(Long id, FiliereDto filiereDto) {
        Filiere filiereExistante = filiereRepository.findById(id)
                .orElseThrow(() -> new FiliereNotFoundException("Filiere not found with id: " + id));

        Filiere filiereMiseAJour = FiliereMapper.mapToFiliere(filiereDto);
        filiereMiseAJour.setId(filiereExistante.getId());
        // Mise à jour des attributs de la filière existante avec les valeurs de filiereDto
        filiereExistante.setName(filiereDto.getName());
        filiereExistante.setNbAnnees(filiereDto.getNbAnnees());
        filiereExistante.setNbSemestres(filiereDto.getNbSemestres());
        filiereExistante.setResponsable(filiereDto.getResponsable());
        filiereExistante.setAnneeDiplomante(filiereDto.getAnneeDiplomante());
        filiereExistante.setAnneesNonDiplomantes(filiereDto.getAnneesNonDiplomantes());
        filiereExistante.setSlug(filiereDto.getSlug());
        filiereMiseAJour.setCreatedAt(filiereExistante.getCreatedAt());
        filiereMiseAJour.setUpdatedAt(LocalDateTime.now());

        Filiere savedFiliere = filiereRepository.save(filiereMiseAJour);
        return FiliereMapper.mapToFiliereDto(savedFiliere);
    }

    @Override
    public void deleteFiliere(Long id) {
        if (!filiereRepository.existsById(id)) {
            throw new FiliereNotFoundException("Filiere is not exists with given id : " + id);
        }
        filiereRepository.deleteById(id);
    }

}