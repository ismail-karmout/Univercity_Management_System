package com.umi.moduleservice.services;

import com.umi.moduleservice.dto.ModuleDto;

import java.util.List;

public interface ModuleService {
    ModuleDto createModule(ModuleDto moduleDto);
    ModuleDto getModuleById(Long moduleId);
    List<ModuleDto> getAllModules();
    ModuleDto updateModule(Long moduleId, ModuleDto updatedModule);
    void deleteModule(Long moduleId);
}
