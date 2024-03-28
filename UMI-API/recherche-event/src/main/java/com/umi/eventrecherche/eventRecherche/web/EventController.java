package com.umi.eventrecherche.eventRecherche.web;


import com.umi.eventrecherche.eventRecherche.clients.LabosRestClient;
import com.umi.eventrecherche.eventRecherche.dtos.EventDto;
import com.umi.eventrecherche.eventRecherche.entities.EventR;
import com.umi.eventrecherche.eventRecherche.entities.ImageModel;
import com.umi.eventrecherche.eventRecherche.enums.EventType;
import com.umi.eventrecherche.eventRecherche.model.Labos;
import com.umi.eventrecherche.eventRecherche.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/eventR")
@CrossOrigin("*")


public class EventController {

    private EventService eventService;
    private LabosRestClient labosRestClient;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
   public EventDto createEvent(@RequestPart("eventDto") EventDto eventDto, @RequestPart("imageFile") MultipartFile[] file){
       //EventDto savedEvent = eventService.createEvent(eventDto);
       //return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        try{
            Set<ImageModel> images = uploadImage(file);
            eventDto.setEventrImages(images);
            return eventService.createEvent(eventDto);


        } catch (Exception e){
            System.out.println(e.getMessage());
            return null ;
        }
   }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for (MultipartFile file: multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAllNews(){
        List<EventDto> event = eventService.getAllNews();
        event.forEach(eevent->{
            eevent.setLabos(labosRestClient.getLabosById(eevent.getLabs_id()));
        });
        return ResponseEntity.ok(event);

    }

    @GetMapping("{id}")
    public ResponseEntity<EventDto> getNewsById(@PathVariable("id") Long eventId){

        EventDto eventDto = eventService.getEventById(eventId);
        Labos labos=labosRestClient.getLabosById(eventDto.getLabs_id());
        eventDto.setLabos(labos);
        return ResponseEntity.ok(eventDto);
    }


    @PutMapping("{id}")

    public ResponseEntity<EventDto> updateNews(@PathVariable("id") Long eventId ,@RequestBody EventDto updateEvent ){

        EventDto eventDto = eventService.updateEvent(eventId , updateEvent);
        return ResponseEntity.ok(eventDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNews( @PathVariable("id") Long eventId ){

        eventService.deleteEvent(eventId);

        return ResponseEntity.ok("");
    }

    @GetMapping("/findByLieu")
    public List<EventR> FindEventByLieu(@RequestParam String lieu) {
        return eventService.FindEventByLieu(lieu);
    }

    @GetMapping("/findByType")
    public ResponseEntity<List<EventR>> findEventsByType(@RequestParam EventType type) {
        List<EventR> events = eventService.FindEventByType(type);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/labos/{id}")
    public ResponseEntity<Labos> getDepartmentById(@PathVariable("id") Long id){
        Labos department = eventService.getLabosById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/labos")
    public ResponseEntity<List<Labos>> getAllDepartments(){
        List<Labos> departments = eventService.getAllLabos();
        return ResponseEntity.ok(departments);
    }


}
