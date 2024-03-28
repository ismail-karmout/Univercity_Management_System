package com.umi.moduleservice.mappers;

import com.umi.moduleservice.dto.ModuleDto;
import com.umi.moduleservice.entities.Module;

public class ModuleMapper {
    public static ModuleDto mapToModuleDto(Module module){
        return new ModuleDto(
                module.getId(),
                module.getName(),
                module.getSlug(),
                module.getProfessorId(),
                module.getProfessor(),
                module.getSemestreId(),
                module.getSemestre(),
                module.getModuleElements(),
                module.getCreated_at(),
                module.getUpdated_at()
        );
    }

    public static Module mapToModule(ModuleDto moduleDto){
        return new Module(
                moduleDto.getId(),
                moduleDto.getName(),
                moduleDto.getSlug(),
                moduleDto.getProfessorId(),
                moduleDto.getProfessor(),
                moduleDto.getSemestreId(),
                moduleDto.getSemestre(),
                moduleDto.getModuleElements(),
                moduleDto.getCreated_at(),
                moduleDto.getUpdated_at()
        );
    }
}
