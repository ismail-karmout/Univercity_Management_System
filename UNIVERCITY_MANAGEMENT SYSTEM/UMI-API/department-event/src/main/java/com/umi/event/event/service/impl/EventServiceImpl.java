package com.umi.event.event.service.impl;

import com.umi.event.event.clients.DepartmentRestClient;
import com.umi.event.event.dto.EventDto;
import com.umi.event.event.entity.Event;
import com.umi.event.event.exception.ResourceNotFoundException;
import com.umi.event.event.mapper.EventMapper;
import com.umi.event.event.model.Department;
import com.umi.event.event.repository.EventRepository;
import com.umi.event.event.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private  DepartmentRestClient departmentRestClient;
    @Override
    public EventDto createEvent(EventDto eventDto){
        Event event = EventMapper.mapToEvent(eventDto);
        event.setCreated_at(new Date());
        Event savedEvent = eventRepository.save(event);
        return EventMapper.mapToEventDto(savedEvent);
    }
    @Override
    public EventDto getEventById(Long eventId){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event is not exist with given id : " + eventId));
        return EventMapper.mapToEventDto(event);
    }
    @Override
    public List<EventDto> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        List<EventDto> collect = events.stream().map((event) -> EventMapper.mapToEventDto(event)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public EventDto updateEvent(Long eventId, EventDto updateEvent){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event is not exist with given id : "+ eventId));

        event.setTitle(updateEvent.getTitle());
        event.setType(updateEvent.getType());
        event.setDescription(updateEvent.getDescription());
        event.setPhoto(updateEvent.getPhoto());
        event.setDate(updateEvent.getDate());
        event.setCreated_at(updateEvent.getCreated_at());
        event.setUpdated_at(updateEvent.getUpdated_at());

        Event updatedEventObj = eventRepository.save(event);
        return EventMapper.mapToEventDto(updatedEventObj);
    }

    @Override
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event is not exist with given id : " + eventId));
        eventRepository.deleteById(eventId);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return  departmentRestClient.getDepartmentById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return  departmentRestClient.getAllDepartments();
    }

}
