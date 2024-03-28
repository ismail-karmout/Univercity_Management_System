package com.umi.researcherservice.controller;

import com.umi.researcherservice.dto.RoleDto;
import com.umi.researcherservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class RoleRestController {
    private RoleService roleService;
    @PostMapping
    ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
        RoleDto createdRole = roleService.createRole(roleDto);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Long roleId){
        RoleDto roleDto = roleService.getRoleById(roleId);
        return ResponseEntity.ok(roleDto);
    }

    @GetMapping
    ResponseEntity<List<RoleDto>> getAllRole(){
        List<RoleDto> roles = roleService.getAllRole();
        return ResponseEntity.ok(roles);
    }

    @PutMapping("{id}")
    ResponseEntity<RoleDto> updateRole(@PathVariable("id") Long id, @RequestBody RoleDto updatedRole){
        RoleDto roleUpdated = roleService.updateRole(id, updatedRole);
        return ResponseEntity.ok(roleUpdated);
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteRole(@PathVariable("id") Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role is deleted successfully");
    }
}
