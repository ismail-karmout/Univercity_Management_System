package com.umi.moduleservice.services.impl;

import com.umi.moduleservice.dto.ModuleElementDto;
import com.umi.moduleservice.entities.Module;
import com.umi.moduleservice.entities.ModuleElement;
import com.umi.moduleservice.exceptions.ResourceNotFoundException;
import com.umi.moduleservice.feign.ProfessorServiceClient;
import com.umi.moduleservice.mappers.ModuleElementMapper;
import com.umi.moduleservice.model.Professor;
import com.umi.moduleservice.repositories.ModuleElementRepository;
import com.umi.moduleservice.services.ModuleElementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModuleElementServiceImpl implements ModuleElementService {
    private ModuleElementRepository moduleElementRepository;
    private ProfessorServiceClient professorServiceClient;
    @Override
    public ModuleElementDto createModuleElement(ModuleElementDto moduleElementDto) {
        ModuleElement moduleElement = ModuleElementMapper.mapToModuleElement(moduleElementDto);
        ModuleElement savedModuleElement = moduleElementRepository.save(moduleElement);
        return ModuleElementMapper.mapToModuleElementDto(savedModuleElement);
    }

    @Override
    public ModuleElementDto getModuleElementDtoById(Long moduleElementId) {
        ModuleElement moduleElement = moduleElementRepository.findById(moduleElementId)
                .orElseThrow(()-> new ResourceNotFoundException("Module Element is not exits with given id " +moduleElementId));
        if (moduleElement.getProfessorId()!= null){
            moduleElement.setProfessor(professorServiceClient.getProfessorById(moduleElement.getProfessorId()));
        }
        return ModuleElementMapper.mapToModuleElementDto(moduleElement);
    }

    @Override
    public List<ModuleElementDto> getAllModuleElement() {
        List<ModuleElement> moduleElements = moduleElementRepository.findAll();

        moduleElements.forEach( moduleElement -> {
            if(moduleElement.getProfessorId() != null) {
                Professor professor = professorServiceClient.getProfessorById(moduleElement.getProfessorId());
                moduleElement.setProfessor(professor);
            }
        });

        return moduleElements.stream().map((moduleElement)-> ModuleElementMapper.mapToModuleElementDto(moduleElement))
                .collect(Collectors.toList());
    }

    @Override
    public ModuleElementDto updateModuleElement(Long moduleElementId, ModuleElementDto updatedModuleElement) {
        ModuleElement moduleElement = moduleElementRepository.findById(moduleElementId)
                .orElseThrow(()-> new ResourceNotFoundException("Module Element is not exits with given id " +moduleElementId));
        if(updatedModuleElement.getName() != null) moduleElement.setName(updatedModuleElement.getName());
        if(updatedModuleElement.getSlug() != null) moduleElement.setSlug(updatedModuleElement.getSlug());
        if(updatedModuleElement.getProfessor() != null) moduleElement.setProfessor(updatedModuleElement.getProfessor());

        ModuleElement updatedModuleElementObj = moduleElementRepository.save(moduleElement);
        return ModuleElementMapper.mapToModuleElementDto(updatedModuleElementObj);
    }

    @Override
    public void deleteModuleElement(Long moduleElementId) {
        ModuleElement moduleElement = moduleElementRepository.findById(moduleElementId)
                .orElseThrow(()-> new ResourceNotFoundException("Module Element is not exits with given id " +moduleElementId));
        moduleElementRepository.deleteById(moduleElementId);
    }
}
