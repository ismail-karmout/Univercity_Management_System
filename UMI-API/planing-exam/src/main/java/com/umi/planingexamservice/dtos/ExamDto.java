package com.umi.planingexamservice.dtos;

import com.umi.planingexamservice.entities.PlaningExam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
    private Long id;
    private String name;
    private String exam;
    private PlaningExam planingExam;
    private Date created_at;
    private Date updated_at;

}
