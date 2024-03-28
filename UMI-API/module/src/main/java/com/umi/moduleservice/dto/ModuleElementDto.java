package com.umi.moduleservice.dto;

import com.umi.moduleservice.entities.Module;
import com.umi.moduleservice.model.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleElementDto {
    private Long id;
    private String name;
    private String slug;
    private Long professorId;
    private Professor professor;
    private Module module;
    private Date created_at;
    private Date updated_at;
}
