package com.umi.publication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO {
//    @JsonProperty("Id")
    private Long id;
//    @JsonProperty(" Iintitule")
    private String type;
//    @JsonProperty("Type")
    private String titre;
//    @JsonProperty("Responsable")
    private Long auteurId;
    private Long anneeUniversitaireId;
    private Long equipeId;
    private Long laboId;

    private String etat;

//    @JsonIgnore
    private String justificatif;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
