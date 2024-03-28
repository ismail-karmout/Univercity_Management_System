package com.umi.studentservice.dto;

import com.umi.studentservice.model.Group;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String cne;
    private String cni;
    private Long groupId;
    private Group group;
    private Date created_at;
    private Date updated_at;
}
