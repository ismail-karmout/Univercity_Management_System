package com.umi.studentservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Group {
    private Long id;
    private String name;
    private String description;
    private String slug;
}
