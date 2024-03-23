package com.umi.event.event.mapper;

import com.umi.event.event.dto.EventDto;
import com.umi.event.event.entity.Event;
import com.umi.event.event.model.Department;
import jakarta.persistence.Transient;

public class EventMapper {
    public static EventDto mapToEventDto(Event event){
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getType(),
                event.getDescription(),
                event.getPhoto(),
                event.getDate(),
                event.getCreated_at(),
                event.getUpdated_at(),
                event.getDepartment_id(),
                event.getDepartment()



        );
    }

    public static Event mapToEvent(EventDto eventDto){
        return new Event(
                eventDto.getId(),
                eventDto.getTitle(),
                eventDto.getType(),
                eventDto.getDescription(),
                eventDto.getPhoto(),
                eventDto.getDate(),
                eventDto.getCreated_at(),
                eventDto.getUpdated_at(),
                eventDto.getDepartment_id(),
                eventDto.getDepartment()
        );
    }
}
