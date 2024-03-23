package com.umi.news.news.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umi.news.news.model.Department;
import jakarta.persistence.*;
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
@Entity
@Table(name="news")
public class News {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
   @Column(name= "title_")
    private String title;

    @Column(name= "date_")

    private Date date;

    @Column(name= "type_")

    private String type;

    @Column(name= "description_")
    private String description;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "news_images",
            joinColumns= {
              @JoinColumn(name = "id")
            },
            inverseJoinColumns = {

            @JoinColumn(name = "image_id")

            }

    )
    private Set<ImageModel> newsImages;

    @Column(name= "photo_")
    private String photo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private Date updatedAt;


    @JoinColumn(name = "department_id")
    @Column(name="department_id")
    private Long department_id ;

    @Transient
    private Department department;


}
