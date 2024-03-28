package com.umi.filiere.groupesection.dto;

import com.umi.filiere.groupesection.entity.Group;
import com.umi.filiere.groupesection.entity.Schedule;
import com.umi.filiere.groupesection.model.Semestre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String slug;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;
    private Long id_semestre;
}
