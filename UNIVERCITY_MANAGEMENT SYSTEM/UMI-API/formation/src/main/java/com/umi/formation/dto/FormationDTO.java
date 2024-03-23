package com.umi.formation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {
//    @JsonProperty("formationId")
    private Long id;
//    @JsonProperty("formationIintitule")
    private String intitule;
//    @JsonProperty("formationType")
    private String typeFormation;
//    @JsonProperty("formationResponsable")
    private String responsable;
//    @JsonIgnore
    private byte[] imageDescriptive;
//    @JsonIgnore
    private String documentDescriptifPath;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
