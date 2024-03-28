package com.umi.moduleservice.controllers;

import com.umi.moduleservice.dto.ModuleDto;
import com.umi.moduleservice.dto.ModuleElementDto;
import com.umi.moduleservice.services.ModuleElementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/module-elements")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ModuleElementRestController {
    private ModuleElementService moduleElementService;

    @PostMapping
    ResponseEntity<ModuleElementDto> createModuleElement(@RequestBody ModuleElementDto moduleElement){
        ModuleElementDto moduleElementDto = moduleElementService.createModuleElement(moduleElement);
        return new ResponseEntity<>(moduleElementDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<ModuleElementDto> getModuleElementById(@PathVariable("id") Long moduleElementId){
        ModuleElementDto moduleElementDto = moduleElementService.getModuleElementDtoById(moduleElementId);
        return ResponseEntity.ok(moduleElementDto);
    }

    @GetMapping
    ResponseEntity<List<ModuleElementDto>> getAllModuleElements(){
        List<ModuleElementDto> moduleElements = moduleElementService.getAllModuleElement();
        return ResponseEntity.ok(moduleElements);
    }

    @PutMapping("{id}")
    ResponseEntity<ModuleElementDto> updateModuleElement(@PathVariable("id") Long moduleElementId, @RequestBody ModuleElementDto updatedModuleElement){
        ModuleElementDto moduleElement = moduleElementService.updateModuleElement(moduleElementId, updatedModuleElement);
        return ResponseEntity.ok(moduleElement);
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteModuleElement(@PathVariable("id") Long moduleElementId){
        moduleElementService.deleteModuleElement(moduleElementId);
        return ResponseEntity.ok("Module Element deleted successfully");
    }
}
