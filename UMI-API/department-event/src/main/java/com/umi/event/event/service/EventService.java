package com.umi.event.event.service;

import com.umi.event.event.dto.EventDto;
import com.umi.event.event.model.Department;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    EventDto getEventById(Long eventId);
    List<EventDto> getAllEvents();

    EventDto updateEvent(Long eventId, EventDto updateEvent);

    void deleteEvent(Long eventId);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
}
