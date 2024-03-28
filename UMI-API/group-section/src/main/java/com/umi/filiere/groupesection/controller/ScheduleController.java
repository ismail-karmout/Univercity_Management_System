package com.umi.filiere.groupesection.controller;

import com.umi.filiere.groupesection.dto.ScheduleRequestDTO;
import com.umi.filiere.groupesection.dto.ScheduleResponseDTO;
import com.umi.filiere.groupesection.entity.Schedule;
import com.umi.filiere.groupesection.entity.Section;
import com.umi.filiere.groupesection.repository.SectionRepository;
import com.umi.filiere.groupesection.service.ScheduleService;
import com.umi.filiere.groupesection.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private SectionService sectionService;
    // Get all Schedules
    @GetMapping
    public List<Schedule> getSchedule(){
        return scheduleService.getAllSchedules();
    }
    // Get Section By Id
    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Long id){
        return scheduleService.getScheduleById(id);
    }
    @GetMapping("/section/{id}")
    public Schedule getScheduleBySectionId(@PathVariable Long id){return scheduleService.getScheduleBySectionId(id);}
    //Create a new Section
    @PostMapping
    public ResponseEntity<ScheduleResponseDTO> createSchedule(@ModelAttribute ScheduleResponseDTO scheduleResponseDTO,
                                                              @RequestParam("file") MultipartFile file){
        Section sc = sectionService.getSectionById(scheduleResponseDTO.getSection().getId());
        scheduleResponseDTO.setSection(sc);
        String fileName="";
        try {
            // Save the file to a specific location or process it as needed
            fileName = file.getOriginalFilename();
            File convertFile = new File("C:\\Users\\NITRO\\Desktop\\MIAAD\\Project2\\Code\\UMI-CLIENT\\src\\assets\\uploads" + fileName);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scheduleResponseDTO.setSchedule(fileName);
        ScheduleResponseDTO savedSchedule = scheduleService.createSchedule(scheduleResponseDTO);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }
    // Update Section
    @PutMapping("/{id}")
    public ScheduleResponseDTO updateSchedule(@PathVariable Long id, @ModelAttribute ScheduleRequestDTO scheduleRequestDTO,
                                              @RequestParam("file") MultipartFile file){
        String fileName="";
        try {
            // Save the file to a specific location or process it as needed
            fileName = file.getOriginalFilename();
            File convertFile = new File("/Users/youssefsaklab/Documents/Files/" + fileName);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scheduleRequestDTO.setSchedule(fileName);
        return scheduleService.updateSchedule(id,scheduleRequestDTO);
    }
    // Delete Section
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
    }
    private static final String UPLOAD_DIRECTORY = "./";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Save the file to a specific location or process it as needed
            String fileName = file.getOriginalFilename();
            File convertFile = new File("/Users/youssefsaklab/Documents/Files/" + fileName);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
            return "File uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file";
        }
    }
}
