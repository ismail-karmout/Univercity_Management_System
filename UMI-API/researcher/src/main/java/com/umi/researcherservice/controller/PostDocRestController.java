package com.umi.researcherservice.controller;

import com.umi.researcherservice.dto.PostDocDto;
import com.umi.researcherservice.service.PostDocService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postDocs")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PostDocRestController {
    private PostDocService postDocService;
    @PostMapping
    ResponseEntity<PostDocDto> createPostDoc(@RequestBody PostDocDto postDocDto){
        PostDocDto createdPostDoc = postDocService.createPostDoc(postDocDto);
        return new ResponseEntity<>(createdPostDoc, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    ResponseEntity<PostDocDto> getPostDocById(@PathVariable("id") Long postDocId){
        PostDocDto postDocDto = postDocService.getPostDocById(postDocId);
        return ResponseEntity.ok(postDocDto);
    }

    @GetMapping
    ResponseEntity<List<PostDocDto>> getAllPostDoc(){
        List<PostDocDto> postDocs = postDocService.getAllPostDoc();
        return ResponseEntity.ok(postDocs);
    }

    @PutMapping("{id}")
    ResponseEntity<PostDocDto> updatePostDoc(@PathVariable("id") Long id, @RequestBody PostDocDto updatedPostDoc){
        PostDocDto postDocUpdated = postDocService.updatePostDoc(id, updatedPostDoc);
        return ResponseEntity.ok(postDocUpdated);
    }

    @DeleteMapping("{id}")
    ResponseEntity<String> deletePostDoc(@PathVariable("id") Long id){
        postDocService.deletePostDoc(id);
        return ResponseEntity.ok("PostDoc is deleted successfully");
    }
}
