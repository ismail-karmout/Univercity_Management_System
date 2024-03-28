package com.umi.eventrecherche.eventRecherche.mappers;


import com.umi.eventrecherche.eventRecherche.dtos.EventDto;
import com.umi.eventrecherche.eventRecherche.entities.EventR;

public class EventMapper {

    public static EventDto mapToEventDto(EventR eventR){
        return new EventDto(
                eventR.getId(),
                eventR.getResponsableId(),
                eventR.getIntitule(),
                eventR.getJustificatif(),
                eventR.getDate(),
                eventR.getLieu(),
                eventR.getDescription(),
                eventR.getImage(),
                eventR.getType(),
                eventR.getCreatedAt(),
                eventR.getUpdatedAt(),
                eventR.getEventrImages(),
                eventR.getLabos(),
                eventR.getLabs_id()

        );
    }

    public static EventR mapToEventR(EventDto eventDto){
        return new EventR(
                eventDto.getId(),
                eventDto.getResponsableId(),
                eventDto.getIntitule(),
                eventDto.getJustificatif(),
                eventDto.getDate(),
                eventDto.getLieu(),
                eventDto.getDescription(),
                eventDto.getEventrImages(),
                eventDto.getImage(),

                eventDto.getType(),
                eventDto.getCreatedAt(),
                eventDto.getUpdatedAt(),


                eventDto.getLabs_id(),
                eventDto.getLabos()


        );
    }



}
