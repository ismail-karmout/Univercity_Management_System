package com.umi.filiere.groupesection.controller;

import com.umi.filiere.groupesection.dto.GroupRequestDTO;
import com.umi.filiere.groupesection.dto.GroupResponseDTO;
import com.umi.filiere.groupesection.entity.Group;
import com.umi.filiere.groupesection.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private GroupService groupService;
    // Get all Groups
    @GetMapping
    public List<Group> getGroup(){
        return groupService.getAllGroups();
    }
    // Get Group By Id
    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id){
        return groupService.getGroupById(id);
    }
    //Create a new Group
    @PostMapping
    public ResponseEntity<GroupResponseDTO> createGroup(@RequestBody GroupResponseDTO groupResponseDTO){
        GroupResponseDTO savedGroup=groupService.createGroup(groupResponseDTO);
        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
    }
    // Update Group
    @PutMapping("/{id}")
    public GroupResponseDTO updateGroup(@PathVariable Long id, @RequestBody GroupRequestDTO groupRequestDTO){
        return groupService.updateGroup(id,groupRequestDTO);
    }
    // Delete Group
    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id){
        groupService.deleteGroup(id);
    }
}
