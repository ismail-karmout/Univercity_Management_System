package com.umi.filiere.groupesection.controller;

import com.umi.filiere.groupesection.dto.SectionRequestDTO;
import com.umi.filiere.groupesection.dto.SectionResponseDTO;
import com.umi.filiere.groupesection.entity.Section;
import com.umi.filiere.groupesection.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/sections")
public class SectionController {
    private SectionService sectionService;
    // Get all Sections
    @GetMapping
    public List<Section> getSection(){
        return sectionService.getAllSections();
    }
    // Get Section By Id
    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable Long id){
        return sectionService.getSectionById(id);
    }
    //Create a new Section
    @PostMapping
    public ResponseEntity<SectionResponseDTO> createSection(@RequestBody SectionResponseDTO sectionResponseDTO){
        SectionResponseDTO savedSection=sectionService.createSection(sectionResponseDTO);
        return new ResponseEntity<>(savedSection, HttpStatus.CREATED);
    }
    // Update Section
    @PutMapping("/{id}")
    public SectionResponseDTO updateSection(@PathVariable Long id, @RequestBody SectionRequestDTO sectionRequestDTO){
        return sectionService.updateSection(id,sectionRequestDTO);
    }
    // Delete Section
    @DeleteMapping("/{id}")
    public void deleteSection(@PathVariable Long id){
        sectionService.deleteSection(id);
    }

}
