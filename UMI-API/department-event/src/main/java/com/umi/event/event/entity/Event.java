package com.umi.event.event.entity;
import com.umi.event.event.model.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title_event")
    private String title;
    @Column(name = "type_event")
    private String type;
    @Column(name = "descroption_event")
    private String description;
    @Column(name = "photo_event")
    private String photo;
    @Column(name = "date_event")
    private Date date;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at_event", nullable = false, updatable = false)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at_event")
    private Date updated_at;

    @JoinColumn(name = "department_id")
    @Column(name="department_id")
    private Long department_id ;

    @Transient
    private Department department;
}
