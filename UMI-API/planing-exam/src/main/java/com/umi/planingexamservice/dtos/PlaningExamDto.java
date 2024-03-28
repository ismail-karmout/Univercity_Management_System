package com.umi.planingexamservice.dtos;

import com.umi.planingexamservice.entities.Exam;
import com.umi.planingexamservice.model.Semestre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaningExamDto {
    private Long id;
    private String avis;
    private String planing;
    private Long semestreId;
    private Semestre semestre;
    private List<Exam> exam;
    private Date created_at;
    private Date updated_at;

}
