package com.umi.filiere.groupesection.dto;

import com.umi.filiere.groupesection.entity.Section;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDTO {
    private Long id;
    private String name;
    private String schedule;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Section section;
}
