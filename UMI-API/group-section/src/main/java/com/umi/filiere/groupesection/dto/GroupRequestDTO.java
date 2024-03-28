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
public class GroupRequestDTO {
    private String name;
    private String description;
    private String slug;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;
    private Section section;
}
