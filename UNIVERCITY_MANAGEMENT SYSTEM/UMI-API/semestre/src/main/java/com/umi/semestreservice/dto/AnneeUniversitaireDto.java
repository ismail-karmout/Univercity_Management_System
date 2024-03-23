package com.umi.semestreservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.umi.semestreservice.entity.AnneeUniversitaire;
import com.umi.semestreservice.entity.Semestre;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnneeUniversitaireDto {

//    @JsonProperty("id")
    private Long id;
//    @JsonProperty("courante")
    private Boolean courante;
//    @JsonProperty("startYear")
    private Integer startYear;
//    @JsonProperty("endYear")
    private Integer endYear;
//    @JsonIgnore
//    private List<Semestre> semestres;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;


}
