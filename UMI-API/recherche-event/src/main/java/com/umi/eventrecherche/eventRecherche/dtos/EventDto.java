package com.umi.eventrecherche.eventRecherche.dtos;


import com.umi.eventrecherche.eventRecherche.entities.ImageModel;
import com.umi.eventrecherche.eventRecherche.enums.EventType;
import com.umi.eventrecherche.eventRecherche.model.Labos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EventDto {

    private Long id;
    private Long responsableId;
    private String intitule;
    private String justificatif;
    private Date date;
    private String lieu;
    private String description;
    private String image;
    private EventType type;
    private Date createdAt;
    private Date updatedAt;
    private Set<ImageModel> eventrImages;
    private Labos labos;
    private Long labs_id ;

}
