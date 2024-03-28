package com.umi.filiere.groupesection.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class Semestre {
        private Long id;
        private String name;
        private AnneeUniversitaire academicYear;
        private String session;
        private String TypeSession;
        private Long idFiliere;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
