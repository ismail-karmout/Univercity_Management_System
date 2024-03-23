package com.umi.news.news.repository;

import com.umi.news.news.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News , Long >{

    List<News> findByTitleContaining(String title);
}
