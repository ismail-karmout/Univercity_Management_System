package com.umi.eventrecherche.eventRecherche.repository;

import com.umi.eventrecherche.eventRecherche.entities.EventR;
import com.umi.eventrecherche.eventRecherche.enums.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventR , Long> {

    List<EventR> findByLieuContaining(String lieu);

    List<EventR> findByType(EventType type);


}
