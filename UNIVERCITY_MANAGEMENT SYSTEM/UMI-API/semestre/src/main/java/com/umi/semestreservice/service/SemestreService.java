package com.umi.semestreservice.service;

import com.umi.semestreservice.dto.AnneeUniversitaireDto;
import com.umi.semestreservice.dto.SemestreDto;

import java.util.List;

public interface SemestreService {

    SemestreDto getSemestreById(Long id);

    List<SemestreDto> getAllSemestre();
    SemestreDto createSemestre(SemestreDto semestreDto);

    SemestreDto updateSemestre(Long id, SemestreDto updatedSemestreDto);

    void deleteSemestre(Long id);


}
