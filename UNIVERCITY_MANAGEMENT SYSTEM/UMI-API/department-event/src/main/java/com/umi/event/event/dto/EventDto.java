package com.umi.event.event.dto;

import com.umi.event.event.model.Department;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private Long id;
    private String title;
    private String type;
    private String description;
    private String photo;
    private Date date;
    private Date created_at;
    private Date updated_at;
    private Long department_id ;
    private Department department;
}
