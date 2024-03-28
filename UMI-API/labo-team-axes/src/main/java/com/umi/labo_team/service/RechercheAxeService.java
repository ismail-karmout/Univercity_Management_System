package com.umi.labo_team.service;

import com.umi.labo_team.dto.RechercheAxeDto;

import java.util.List;

public interface RechercheAxeService {
    RechercheAxeDto createRechercheAxe(RechercheAxeDto rechercheAxeDto);
    RechercheAxeDto getRechercheAxeById(Long rechercheAxeId);
    List<RechercheAxeDto> getAllRechercheAxes();
    RechercheAxeDto updateRechercheAxe(Long rechercheAxeId, RechercheAxeDto rechercheAxeDto);
    void deleteRechercheAxe(Long rechercheAxeId);
}
