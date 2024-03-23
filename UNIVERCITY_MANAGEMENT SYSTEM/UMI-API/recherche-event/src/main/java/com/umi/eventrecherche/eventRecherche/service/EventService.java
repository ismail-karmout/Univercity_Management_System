package com.umi.eventrecherche.eventRecherche.service;

import com.umi.eventrecherche.eventRecherche.dtos.EventDto;
import com.umi.eventrecherche.eventRecherche.entities.EventR;
import com.umi.eventrecherche.eventRecherche.enums.EventType;
import com.umi.eventrecherche.eventRecherche.model.Labos;

import java.util.List;

public interface EventService {

    EventDto createEvent(EventDto eventDto);
    List<EventDto> getAllNews();

    EventDto getEventById(Long eventId);

    EventDto updateEvent(Long eventId , EventDto updatedNews);

    void deleteEvent(Long eventId );

    List<EventR> FindEventByLieu(String lieu);

    List<EventR> FindEventByType(EventType type);

    Labos getLabosById(Long id);
    List<Labos> getAllLabos();



}
