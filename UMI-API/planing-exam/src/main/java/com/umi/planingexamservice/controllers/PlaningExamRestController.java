package com.umi.planingexamservice.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umi.planingexamservice.dtos.PlaningExamDto;
import com.umi.planingexamservice.entities.PlaningExam;
import com.umi.planingexamservice.repositories.PlaningExamRepository;
import com.umi.planingexamservice.services.PlaningExamService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.awt.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/planing-exams")
@AllArgsConstructor
public class PlaningExamRestController {
    private PlaningExamService planingExamService;
    PlaningExamRepository planingExamRepository;
    private static final Logger logger = LoggerFactory.getLogger(PlaningExamRestController.class);

//    @PostMapping
//    public ResponseEntity<PlaningExamDto> createPlaningExam(@RequestBody PlaningExamDto planingExamDto){
//        PlaningExamDto savedPlaningExam = planingExamService.createPlaningExam(planingExamDto);
//        return new ResponseEntity<>(savedPlaningExam, HttpStatus.CREATED);
//    }

//    @PostMapping("/savePlaningExam")
//    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
//                                        @RequestParam("planingExam") String planingExam) throws JsonParseException, JsonMappingException, Exception {
//        try {
//            planingExamService.saveFile(file);
//            return ResponseEntity.ok().build();
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @PostMapping
    public ResponseEntity<Void> createPlaningExam(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("planingExam") String planingExam) throws JsonParseException, JsonMappingException, Exception {

        PlaningExam planingExamm = new ObjectMapper().readValue(planingExam, PlaningExam.class);

        Path uploadDir = Paths.get("uploads");

        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        // Save the file to the specified directory
//        Path filePath = uploadDir.resolve(fileName);
//        Files.copy(file.getInputStream(), filePath);

//        planingExamm.setPlaning(filePath.toString()); // Set the file path as a string
        planingExamm.setPlaning(savePlaningExam(file));

        // Save the PlaningExam entity and return its ID
        planingExamRepository.save(planingExamm);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



    private String savePlaningExam(MultipartFile file) throws IOException {
        String planingPath = "uploads/" + file.getOriginalFilename();
        String planing = file.getOriginalFilename();
//        String planingPath = file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(planingPath), StandardCopyOption.REPLACE_EXISTING);
        return planing;
    }


//    @GetMapping("/download/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
//        Path filePath = Paths.get("uploads").resolve(fileName).normalize();
//        Resource resource;
//        try {
//            resource = new UrlResource(filePath.toUri());
//        } catch (MalformedURLException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found", e);
//        }
//
//        if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource;

        Path filePath = Paths.get("uploads").resolve(fileName).toAbsolutePath().normalize();

        try {
            resource = new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found", e);
        }

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @GetMapping("{id}")
    public ResponseEntity<PlaningExamDto> getPlaningExamById(@PathVariable("id") Long planingExamId){
        PlaningExamDto planingExamDto = planingExamService.getPlaningExamById(planingExamId);
        return ResponseEntity.ok(planingExamDto);
    }

    @GetMapping
    public ResponseEntity<List<PlaningExamDto>> getAllPlaningExam(){
        List<PlaningExamDto> planingExams = planingExamService.getAllPlaningExam();
        return ResponseEntity.ok(planingExams);
    }

    @PutMapping("{id}")
    public ResponseEntity<PlaningExamDto> updatePlaningExam(@PathVariable("id") Long planingExamId, @RequestBody PlaningExamDto updatedPlaningExam){
        PlaningExamDto planingExam = planingExamService.updatePlaningExam(planingExamId, updatedPlaningExam);
        return  ResponseEntity.ok(planingExam);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlaningExam(@PathVariable("id") Long planingExamId){
        planingExamService.deletePlaningExam(planingExamId);
        return ResponseEntity.ok("Planing exam deleted successfully");
    }
}
