package com.umi.moduleservice.services;

import com.umi.moduleservice.dto.ModuleElementDto;

import java.util.List;

public interface ModuleElementService {
    ModuleElementDto createModuleElement(ModuleElementDto moduleElementDto);
    ModuleElementDto getModuleElementDtoById(Long moduleElementId);
    List<ModuleElementDto> getAllModuleElement();
    ModuleElementDto updateModuleElement(Long moduleElementId, ModuleElementDto updatedModuleElement);
    void deleteModuleElement(Long moduleElementId);
}
