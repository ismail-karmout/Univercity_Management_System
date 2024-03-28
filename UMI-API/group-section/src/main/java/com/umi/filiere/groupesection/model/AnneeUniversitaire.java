package com.umi.filiere.groupesection.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.time.Year;
@Data @NoArgsConstructor @AllArgsConstructor
public class AnneeUniversitaire {
    private Long id;
    private Boolean courante;
    private Integer startYear;
    private Integer endYear;
    private List<Semestre> semestres;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
