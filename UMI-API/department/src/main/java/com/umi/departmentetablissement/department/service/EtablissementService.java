package com.umi.departmentetablissement.department.service;

import com.umi.departmentetablissement.department.dto.DepartmentDto;
import com.umi.departmentetablissement.department.dto.EtablissementDto;

import java.util.List;

public interface EtablissementService {
    EtablissementDto createEtablissement(EtablissementDto etablissementDto);
    EtablissementDto getEtablissementById(Long etablissementId);
    List<EtablissementDto> getAllEtablissements();
    EtablissementDto updateEtablissement(Long etablissementId, EtablissementDto etablissementDto);
    void deleteEtablissement(Long etablissementId);
}
