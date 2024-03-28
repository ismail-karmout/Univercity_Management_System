package com.umi.eventrecherche.eventRecherche.service.Impl;

import com.umi.eventrecherche.eventRecherche.clients.LabosRestClient;
import com.umi.eventrecherche.eventRecherche.dtos.EventDto;
import com.umi.eventrecherche.eventRecherche.entities.EventR;
import com.umi.eventrecherche.eventRecherche.enums.EventType;
import com.umi.eventrecherche.eventRecherche.exception.RessourceNotFoundException;
import com.umi.eventrecherche.eventRecherche.mappers.EventMapper;
import com.umi.eventrecherche.eventRecherche.model.Labos;
import com.umi.eventrecherche.eventRecherche.repository.EventRepository;
import com.umi.eventrecherche.eventRecherche.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private LabosRestClient labosRestClient;
    @Override
    public EventDto createEvent(EventDto eventDto) {
        EventR eventR= EventMapper.mapToEventR(eventDto);
        eventR.setCreatedAt(new Date());
        EventR savedEvent = eventRepository.save(eventR);
        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public List<EventDto> getAllNews() {
        List<EventR> eventR= eventRepository.findAll();
        return eventR.stream().map((news1 -> EventMapper.mapToEventDto(news1)))
                .collect(Collectors.toList());


    }

    @Override
    public EventDto getEventById(Long eventId) {

        EventR event = eventRepository.findById(eventId)
                .orElseThrow(() ->
                        new RessourceNotFoundException("No news exists with given id: " +eventId));

        return EventMapper.mapToEventDto(event);

    }



    @Override
    public EventDto updateEvent(Long eventId, EventDto updatedEvent) {

        EventR eventR = eventRepository.findById(eventId).orElseThrow(
                ()-> new RessourceNotFoundException(" Event is not exist with given id "+eventId)
        );


        eventR.setDate(updatedEvent.getDate());
        eventR.setType(updatedEvent.getType());
        eventR.setDescription(updatedEvent.getDescription());
        eventR.setImage(updatedEvent.getImage());
        eventR.setIntitule(updatedEvent.getIntitule());
        eventR.setJustificatif(updatedEvent.getJustificatif());
        eventR.setResponsableId(updatedEvent.getResponsableId());
        eventR.setLieu(updatedEvent.getLieu());
        eventR.setUpdatedAt(new Date());


        EventR updatedEventObj = eventRepository.save(eventR);
        return EventMapper.mapToEventDto(updatedEventObj);


    }

    @Override
    public void deleteEvent(Long eventId) {

        EventR eventR = eventRepository.findById(eventId).orElseThrow(
                ()-> new RessourceNotFoundException(" Event recherche is not exist with given id "+ eventId)
        );

        eventRepository.deleteById(eventId);


    }

    @Override
    public List<EventR> FindEventByLieu(String lieu) {
        return eventRepository.findByLieuContaining(lieu);
    }

    @Override
    public List<EventR> FindEventByType(EventType type) {
        return eventRepository.findByType(type);
    }

    @Override
    public List<Labos> getAllLabos() {
        return  labosRestClient.getAllLabos();
    }

    @Override
    public Labos getLabosById(Long id) {
        return  labosRestClient.getLabosById(id);
    }



}
