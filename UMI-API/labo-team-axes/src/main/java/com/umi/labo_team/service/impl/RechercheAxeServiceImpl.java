package com.umi.labo_team.service.impl;


import com.umi.labo_team.dto.RechercheAxeDto;
import com.umi.labo_team.entity.RechercheAxe;
import com.umi.labo_team.exception.ResourceNotFoundException;
import com.umi.labo_team.mapper.RechercheAxeMapper;
import com.umi.labo_team.repository.RechercheAxeRepository;
import com.umi.labo_team.service.RechercheAxeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RechercheAxeServiceImpl implements RechercheAxeService {

    private final RechercheAxeRepository  rechercheAxeRepository;

    @Override
    public RechercheAxeDto createRechercheAxe(RechercheAxeDto rechercheAxeDto) {
        RechercheAxe rechercheAxe = RechercheAxeMapper.mapToRechercheAxe(rechercheAxeDto);
        RechercheAxe savedRechercheAxe = rechercheAxeRepository.save(rechercheAxe);
        return RechercheAxeMapper.mapTorechercheAxeDto(savedRechercheAxe);
    }

    @Override
    public RechercheAxeDto getRechercheAxeById(Long rechercheAxeId) {
        RechercheAxe rechercheAxe = rechercheAxeRepository.findById(rechercheAxeId).orElseThrow(() -> new ResourceNotFoundException("The department is not exist with the given id: " + rechercheAxeId));
        return RechercheAxeMapper.mapTorechercheAxeDto(rechercheAxe);
    }

    @Override
    public List<RechercheAxeDto> getAllRechercheAxes() {
        List<RechercheAxe> rechercheAxeRepositoryAll = rechercheAxeRepository.findAll();
        return rechercheAxeRepositoryAll.stream().map((rechercheAxe) -> RechercheAxeMapper.mapTorechercheAxeDto(rechercheAxe)).collect(Collectors.toList());
    }

    @Override
    public RechercheAxeDto updateRechercheAxe(Long rechercheAxeId, RechercheAxeDto updateRechercheAxe) {
        RechercheAxe department = rechercheAxeRepository.findById(rechercheAxeId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + rechercheAxeId));
        if (updateRechercheAxe.getName() != null)
            department.setName(updateRechercheAxe.getName());
        if (updateRechercheAxe.getSlug() != null)
            department.setSlug(updateRechercheAxe.getSlug());
        department.setUpdatedAt(LocalDateTime.now());
        RechercheAxe updatedRechercheAxeObj = rechercheAxeRepository.save(department);
        return RechercheAxeMapper.mapTorechercheAxeDto(updatedRechercheAxeObj);
    }

    @Override
    public void deleteRechercheAxe(Long rechercheAxeId) {
        RechercheAxe rechercheAxe = rechercheAxeRepository.findById(rechercheAxeId).orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id: " + rechercheAxeId));
        rechercheAxeRepository.deleteById(rechercheAxeId);

    }
}
