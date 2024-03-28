package com.umi.moduleservice.dto;

import com.umi.moduleservice.entities.ModuleElement;
import com.umi.moduleservice.model.Professor;
import com.umi.moduleservice.model.Semestre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto {
    private Long id;
    private String name;
    private String slug;
    private Long professorId;

    private Professor professor;
    private Long semestreId;
    private Semestre semestre;
    private List<ModuleElement> moduleElements;
    private Date created_at;
    private Date updated_at;
}
