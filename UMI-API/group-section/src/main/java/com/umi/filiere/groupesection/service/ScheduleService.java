package com.umi.filiere.groupesection.service;

import com.umi.filiere.groupesection.dto.ScheduleRequestDTO;
import com.umi.filiere.groupesection.dto.ScheduleResponseDTO;
import com.umi.filiere.groupesection.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDTO createSchedule(ScheduleResponseDTO scheduleResponseDTO);
    public List<Schedule> getAllSchedules();
    public Schedule getScheduleById(Long id);
    public Schedule getScheduleBySectionId(Long Id);
    public ScheduleResponseDTO updateSchedule(Long id, ScheduleRequestDTO scheduleRequestDTO);
    public Boolean deleteSchedule(Long id);
}
