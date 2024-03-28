package com.umi.news.news.service;

import com.umi.news.news.dtos.NewsDto;
import com.umi.news.news.entities.News;
import com.umi.news.news.model.Department;

import java.util.List;

public interface NewsService {

    NewsDto createNews(NewsDto newsDto);
    NewsDto getNewsById(Long newsId);


    List<NewsDto> getAllNews();

    NewsDto updateNews(Long newsId , NewsDto updatedNews);

    void deleteNews(Long newsId );

    List<News> FindNewsByTitre(String titre);

    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();

    void assignNewsToDepartment(Long newsId , Long departmentId);



}
