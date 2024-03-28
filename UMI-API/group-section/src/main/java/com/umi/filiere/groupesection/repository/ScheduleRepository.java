package com.umi.filiere.groupesection.repository;

import com.umi.filiere.groupesection.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    Schedule findScheduleBySectionId(Long id);
}
