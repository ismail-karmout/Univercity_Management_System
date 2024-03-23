package com.umi.event.event.controller;

import com.umi.event.event.clients.DepartmentRestClient;
import com.umi.event.event.dto.EventDto;
import com.umi.event.event.model.Department;
import com.umi.event.event.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {
    private EventService eventService;
    private DepartmentRestClient departmentRestClient;

    // Build Add Event REST API
    @PostMapping
    public ResponseEntity<EventDto>  createEvent(@RequestBody EventDto eventDto) {
        EventDto savedEvent = eventService.createEvent(eventDto);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    // Build Get Event REST API
    @GetMapping("{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable("id") Long eventId){
        EventDto eventDto = eventService.getEventById(eventId);
        Department department=departmentRestClient.getDepartmentById(eventDto.getDepartment_id());
        eventDto.setDepartment(department);
        return ResponseEntity.ok(eventDto);
    }

    //Build Get All Events REST API
    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents(){
        List<EventDto> events = eventService.getAllEvents();
        events.forEach(eevant->{
            eevant.setDepartment(departmentRestClient.getDepartmentById(eevant.getDepartment_id()));
        });

        return ResponseEntity.ok(events);
    }

    //Build Update Event REST API
    @PutMapping("{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long eventId, @RequestBody EventDto updatedEvent){
        EventDto eventDto = eventService.updateEvent(eventId, updatedEvent);
        return ResponseEntity.ok(eventDto);
    }

    //Build Delete Event REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventId){
        eventService.getEventById(eventId);
        return ResponseEntity.ok("Event deleted successfully !.");
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        Department department = eventService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = eventService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}
