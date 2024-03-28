package com.umi.moduleservice.controllers;

import com.umi.moduleservice.dto.ModuleDto;
import com.umi.moduleservice.services.ModuleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/m/modules")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ModuleRestController {
    private ModuleService moduleService;

    @PostMapping
    ResponseEntity<ModuleDto> createModule(@RequestBody ModuleDto module){
        ModuleDto moduleDto = moduleService.createModule(module);
        return new ResponseEntity<>(moduleDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<ModuleDto> getModuleById(@PathVariable("id") Long id){
        ModuleDto module = moduleService.getModuleById(id);
        return ResponseEntity.ok(module);
    }

    @GetMapping
    ResponseEntity<List<ModuleDto>> getAllModules(){
        List<ModuleDto> modules = moduleService.getAllModules();
        return ResponseEntity.ok(modules);
    }

    @PutMapping("{id}")
    ResponseEntity<ModuleDto> updateModule(@PathVariable("id") Long id, @RequestBody ModuleDto updatedModule){
        ModuleDto moduleDto = moduleService.updateModule(id, updatedModule);
        return ResponseEntity.ok(moduleDto);
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteModule(@PathVariable("id") Long id){
        moduleService.deleteModule(id);
        return ResponseEntity.ok("Module deleted successfully");
    }
}
