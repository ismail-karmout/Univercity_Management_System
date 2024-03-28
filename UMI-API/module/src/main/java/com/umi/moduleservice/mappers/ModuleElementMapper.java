package com.umi.moduleservice.mappers;

import com.umi.moduleservice.dto.ModuleElementDto;
import com.umi.moduleservice.entities.ModuleElement;

public class ModuleElementMapper {
    public static ModuleElementDto mapToModuleElementDto(ModuleElement moduleElement){
        return new ModuleElementDto(
                moduleElement.getId(),
                moduleElement.getName(),
                moduleElement.getSlug(),
                moduleElement.getProfessorId(),
                moduleElement.getProfessor(),
                moduleElement.getModule(),
                moduleElement.getCreated_at(),
                moduleElement.getUpdated_at()
        );
    }

    public static ModuleElement mapToModuleElement(ModuleElementDto moduleElementDto){
        return new ModuleElement(
                moduleElementDto.getId(),
                moduleElementDto.getName(),
                moduleElementDto.getSlug(),
                moduleElementDto.getProfessorId(),
                moduleElementDto.getProfessor(),
                moduleElementDto.getModule(),
                moduleElementDto.getCreated_at(),
                moduleElementDto.getUpdated_at()
        );
    }
}
