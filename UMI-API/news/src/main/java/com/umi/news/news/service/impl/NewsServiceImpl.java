package com.umi.news.news.service.impl;

import com.umi.news.news.clients.DepartmentRestClient;
import com.umi.news.news.dtos.NewsDto;
import com.umi.news.news.entities.News;
import com.umi.news.news.exception.RessourceNotFoundException;
import com.umi.news.news.mappers.NewsMapper;
import com.umi.news.news.repository.NewsRepository;
import com.umi.news.news.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.umi.news.news.model.Department;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {

 private NewsRepository newsRepository;
 private DepartmentRestClient departmentRestClient;
    @Override
    public NewsDto createNews(NewsDto newsDto) {
        News news = NewsMapper.mapToNews(newsDto);
        news.setCreatedAt(new Date());
        News savedNews = newsRepository.save(news);
        return NewsMapper.mapToNewsDto(savedNews);

    }

    @Override
    public NewsDto getNewsById(Long newsId) {
         News news = newsRepository.findById(newsId)
                 .orElseThrow(() ->
                         new RessourceNotFoundException("No news exists with given id: " +newsId));

         return NewsMapper.mapToNewsDto(news);

    }

    @Override
    public List<NewsDto> getAllNews() {
        List<News> news= newsRepository.findAll();
        return news.stream().map((news1 -> NewsMapper.mapToNewsDto(news1)))
                .collect(Collectors.toList());
    }

    @Override
    public NewsDto updateNews(Long newsId, NewsDto updatedNews) {


        News news = newsRepository.findById(newsId).orElseThrow(
                ()-> new RessourceNotFoundException(" News is not exist with given id "+ newsId)
        );
        news.setUpdatedAt(new Date());

        news.setTitle(updatedNews.getTitle());
        news.setDate(updatedNews.getDate());
        news.setType(updatedNews.getType());
        news.setDescription(updatedNews.getDescription());
        news.setPhoto(updatedNews.getPhoto());
        news.setCreatedAt(updatedNews.getCreatedAt());



        News updatedNewsObj = newsRepository.save(news);
        return NewsMapper.mapToNewsDto(updatedNewsObj);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return  departmentRestClient.getDepartmentById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return  departmentRestClient.getAllDepartments();
    }

    @Override
    public void assignNewsToDepartment(Long newsId, Long departmentId) {
        News news = newsRepository.findById(newsId).orElseThrow(
                ()-> new RessourceNotFoundException(" News is not exist with given id "+ newsId)
        );

        Department department = departmentRestClient.getDepartmentById(newsId);

            news.setDepartment(department);

        News saveNews = newsRepository.save(news);


    }


    @Override
    public void deleteNews(Long newsId) {

        News news = newsRepository.findById(newsId).orElseThrow(
                ()-> new RessourceNotFoundException(" News is not exist with given id "+ newsId)
        );

        newsRepository.deleteById(newsId);

    }

    @Override
    public List<News> FindNewsByTitre(String titre) {
        return newsRepository.findByTitleContaining(titre);
    }

}
