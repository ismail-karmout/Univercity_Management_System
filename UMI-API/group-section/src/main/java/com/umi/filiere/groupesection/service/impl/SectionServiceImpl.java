package com.umi.filiere.groupesection.service.impl;

import com.umi.filiere.groupesection.dto.SectionRequestDTO;
import com.umi.filiere.groupesection.dto.SectionResponseDTO;
import com.umi.filiere.groupesection.entity.Section;
import com.umi.filiere.groupesection.mapper.SectionMapper;
import com.umi.filiere.groupesection.repository.SectionRepository;
import com.umi.filiere.groupesection.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SectionServiceImpl implements SectionService {
    @Autowired
    public SectionMapper sectionMapper;
    @Autowired
    public SectionRepository sectionRepository;
    @Override
    public SectionResponseDTO createSection(SectionResponseDTO sectionResponseDTO) {
        Section section= SectionMapper.mapToSection(sectionResponseDTO);
        section.setCreated_at(LocalDateTime.now());
        Section savedSection= sectionRepository.save(section);
        return SectionMapper.mapToSectionDTO(savedSection);
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Section getSectionById(Long id) {
        return sectionRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Section %s not found !", id)));
    }
    @Override
    public SectionResponseDTO updateSection(Long id, SectionRequestDTO sectionRequestDTO) {
        Section section=Section.builder()
                .id(id)
                .name(sectionRequestDTO.getName())
                .description(sectionRequestDTO.getDescription())
                .slug(sectionRequestDTO.getSlug())
                .created_at(sectionRequestDTO.getCreated_at())
                .updated_at(LocalDateTime.now())
                .deleted_at(sectionRequestDTO.getDeleted_at())
                .id_semestre(sectionRequestDTO.getId_semestre())
                .build();
        Section savecSection=sectionRepository.save(section);
        SectionResponseDTO sectionResponseDTO=sectionMapper.mapToSectionDTO(savecSection);
        return sectionResponseDTO;
    }

    @Override
    public Boolean deleteSection(Long id) {
        sectionRepository.deleteById(id);
        return true;
    }
}
