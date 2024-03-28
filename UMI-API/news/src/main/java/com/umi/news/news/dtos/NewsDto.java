package com.umi.news.news.dtos;

import com.umi.news.news.entities.ImageModel;
import com.umi.news.news.model.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NewsDto {

    private Long id;
    private String title;
    private Date date;

    private String type;
    private String description;
    private String photo;
    private Date createdAt;
    private Date updatedAt;
    private Set<ImageModel> newsImages;
    private Department department;
    private Long department_id ;

}
