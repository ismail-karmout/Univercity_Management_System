package com.umi.filiere.groupesection.mapper;


import com.umi.filiere.groupesection.dto.SectionResponseDTO;
import com.umi.filiere.groupesection.entity.Section;
import org.springframework.stereotype.Component;

@Component
public class SectionMapper {
    public static SectionResponseDTO mapToSectionDTO(Section section){
        return new SectionResponseDTO(section.getId(),
                section.getName(),
                section.getDescription(),
                section.getSlug(),
                section.getCreated_at(),
                section.getUpdated_at(),
                section.getDeleted_at(),
                section.getId_semestre()
        );
    }
    public static Section mapToSection(SectionResponseDTO sectionResponseDTO){
        return new Section(sectionResponseDTO.getId(),
                sectionResponseDTO.getName(),
                sectionResponseDTO.getDescription(),
                sectionResponseDTO.getSlug(),
                sectionResponseDTO.getCreated_at(),
                sectionResponseDTO.getUpdated_at(),
                sectionResponseDTO.getDeleted_at(),
                sectionResponseDTO.getId_semestre());
    }
}
