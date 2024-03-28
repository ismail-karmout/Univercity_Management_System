package com.umi.moduleservice.services.impl;

import com.umi.moduleservice.dto.ModuleDto;
import com.umi.moduleservice.entities.Module;
import com.umi.moduleservice.entities.ModuleElement;
import com.umi.moduleservice.exceptions.ResourceNotFoundException;
import com.umi.moduleservice.feign.ProfessorServiceClient;
import com.umi.moduleservice.feign.SemestreServiceClient;
import com.umi.moduleservice.mappers.ModuleMapper;
import com.umi.moduleservice.model.Professor;
import com.umi.moduleservice.model.Semestre;
import com.umi.moduleservice.repositories.ModuleElementRepository;
import com.umi.moduleservice.repositories.ModuleRepository;
import com.umi.moduleservice.services.ModuleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private ModuleRepository moduleRepository;
    private ModuleElementRepository moduleElementRepository;
    private ProfessorServiceClient professorServiceClient;
    private SemestreServiceClient semestreServiceClient;
    @Override
    public ModuleDto createModule(ModuleDto moduleDto) {
        Module module = ModuleMapper.mapToModule(moduleDto);
        Module savedModule = moduleRepository.save(module);
        return ModuleMapper.mapToModuleDto(savedModule);
    }

    @Override
    public ModuleDto getModuleById(Long moduleId) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(()-> new ResourceNotFoundException("Module is not exits with given id "+moduleId));

        if(module.getProfessorId()!= null){
            module.setProfessor(professorServiceClient.getProfessorById(module.getProfessorId()));
        }

        if(module.getSemestreId()!= null){
            module.setSemestre(semestreServiceClient.getSemestreById(module.getSemestreId()));
        }

        return ModuleMapper.mapToModuleDto(module);
    }

    @Override
    public List<ModuleDto> getAllModules() {
        List<Module> modules = moduleRepository.findAll();

        modules.forEach( module -> {
            if(module.getProfessorId() != null) {
                Professor professor = professorServiceClient.getProfessorById(module.getProfessorId());
                module.setProfessor(professor);
            }

            if(module.getSemestreId() != null){
                Semestre semestre =  semestreServiceClient.getSemestreById(module.getSemestreId());
                module.setSemestre(semestre);
            }
        });

        return modules.stream().map((module) -> ModuleMapper.mapToModuleDto(module))
                .collect(Collectors.toList());
    }

    @Override
    public ModuleDto updateModule(Long moduleId, ModuleDto updatedModule) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(()-> new ResourceNotFoundException("Module is not exits with given id "+moduleId));
        if(updatedModule.getName() != null) module.setName(updatedModule.getName());
        if(updatedModule.getProfessor() != null) module.setProfessor(updatedModule.getProfessor());

        Module updatedModuleObj = moduleRepository.save(module);
        return ModuleMapper.mapToModuleDto(updatedModuleObj);
    }

    @Override
    public void deleteModule(Long moduleId) {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(()-> new ResourceNotFoundException("Module is not exits with given id "+moduleId));

        List<ModuleElement> moduleElements = moduleElementRepository.findByModule(module);
        for(ModuleElement element : moduleElements) {
            moduleElementRepository.delete(element);
        }
        moduleRepository.deleteById(moduleId);
    }
}
