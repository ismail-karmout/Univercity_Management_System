package com.umi.event.event.repository;

import com.umi.event.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    //List<Event> findByTitleContaining(String title);
}
