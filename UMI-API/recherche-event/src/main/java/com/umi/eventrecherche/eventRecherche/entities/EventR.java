package com.umi.eventrecherche.eventRecherche.entities;


import com.umi.eventrecherche.eventRecherche.enums.EventType;
import com.umi.eventrecherche.eventRecherche.model.Labos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="eventR")

public class EventR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name= "responsable_id")
    private Long responsableId;

    @Column(name= "intitule_")
    private String intitule;

    @Column(name= "justificatif_")
    private String justificatif;


    @Column(name= "date_")

    private Date date;

    @Column(name= "lieu_")

    private String lieu;

    @Column(name= "description_")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "event_images",
            joinColumns= {
                    @JoinColumn(name = "id")
            },
            inverseJoinColumns = {

                    @JoinColumn(name = "image_id")

            }

    )
    private Set<ImageModel> eventrImages;

    @Column(name= "image_")
    private String image;

    @Column(name= "type_")
    private EventType type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private Date updatedAt;

    @JoinColumn(name = "labs_id")
    @Column(name="labs_id")
    private Long labs_id ;

    @Transient
    private Labos labos;

}
