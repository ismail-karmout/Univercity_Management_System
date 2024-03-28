package com.umi.news.news.web;

import com.umi.news.news.clients.DepartmentRestClient;
import com.umi.news.news.dtos.NewsDto;
import com.umi.news.news.entities.ImageModel;
import com.umi.news.news.entities.News;
import com.umi.news.news.model.Department;
import com.umi.news.news.service.NewsService;
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
@RequestMapping("/api/news")
@CrossOrigin("*")
public class NewsController {
    private DepartmentRestClient departmentRestClient;

    private NewsService newsService;
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})

    public NewsDto createNews(@RequestPart("newsDto") NewsDto newsDto, @RequestPart("imageFile") MultipartFile[] file ){
        //NewsDto savedNews = newsService.createNews(newsDto);
        //return new ResponseEntity<>(savedNews, HttpStatus.CREATED);
        try{
            Set<ImageModel> images = uploadImage(file);
            newsDto.setNewsImages(images);
            return newsService.createNews(newsDto);


        } catch (Exception e){
            System.out.println(e.getMessage());
            return null ;
        }
    }
    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException{
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

    @PostMapping("{newsId}/assign-department/{departmentId}")
    ResponseEntity<String> assignNewsToDepartment(
            @PathVariable("newsId") Long newsId,
            @PathVariable("departmentId") Long departmentId)

    {
        newsService.assignNewsToDepartment(newsId, departmentId);
        return ResponseEntity.ok("Department assigned successfully");
    }



    @GetMapping("{id}")
    public ResponseEntity<NewsDto> getNewsById(@PathVariable("id") Long newsId){

        NewsDto newsDto = newsService.getNewsById(newsId);
        Department department=departmentRestClient.getDepartmentById(newsDto.getDepartment_id());
        newsDto.setDepartment(department);
        return ResponseEntity.ok(newsDto);
    }
    @GetMapping
    public ResponseEntity<List<NewsDto>> getAllNews(){
        List<NewsDto> news = newsService.getAllNews();
        news.forEach(nnews->{
            nnews.setDepartment(departmentRestClient.getDepartmentById(nnews.getDepartment_id()));
        });
        return ResponseEntity.ok(news);

    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        Department department = newsService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = newsService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }


    @PutMapping("{id}")

    public ResponseEntity<NewsDto> updateNews(@PathVariable("id") Long newsId ,@RequestBody NewsDto updatedNews ){

        NewsDto newsDto = newsService.updateNews(newsId , updatedNews);
        return ResponseEntity.ok(newsDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNews( @PathVariable("id") Long newsId ){

        newsService.deleteNews(newsId);

        return ResponseEntity.ok("");
    }



    @GetMapping("/find")
    public List<News> FindNewsByTitre(@RequestParam String titre) {
        return newsService.FindNewsByTitre(titre);
    }



}
