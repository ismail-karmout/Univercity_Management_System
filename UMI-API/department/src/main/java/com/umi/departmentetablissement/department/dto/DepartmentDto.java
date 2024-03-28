package com.umi.departmentetablissement.department.dto;

import com.umi.departmentetablissement.department.entity.Etablissement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentDto {
    private Long id;
    private String name;
    private String description;
    private String slug;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;
//    private Long etablissement_id;
    private Etablissement etablissement;
}
