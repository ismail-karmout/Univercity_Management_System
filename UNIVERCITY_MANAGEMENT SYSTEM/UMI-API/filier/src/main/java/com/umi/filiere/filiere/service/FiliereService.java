package com.umi.filiere.filiere.service;

import com.umi.filiere.filiere.dto.FiliereDto;
import com.umi.filiere.filiere.models.Department;
import com.umi.filiere.filiere.service.impl.FiliereServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FiliereService  {
    List<FiliereDto> getAllFilieres();
    FiliereDto getFiliereById(Long id);
    FiliereDto addFiliere(FiliereDto filiereDTO);
    Department getDepartmentById(Long id);
    FiliereDto updateFiliere(Long id, FiliereDto filiereDTO);
    void deleteFiliere(Long id);}


