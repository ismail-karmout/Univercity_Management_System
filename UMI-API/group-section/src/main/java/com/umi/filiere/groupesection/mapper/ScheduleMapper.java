package com.umi.filiere.groupesection.mapper;

import com.umi.filiere.groupesection.dto.ScheduleRequestDTO;
import com.umi.filiere.groupesection.dto.ScheduleResponseDTO;
import com.umi.filiere.groupesection.entity.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {
    public static ScheduleResponseDTO mapToScheduleDTO(Schedule schedule){
        return new ScheduleResponseDTO(
                schedule.getId(),
                schedule.getName(),
                schedule.getSchedule(),
                schedule.getCreated_at(),
                schedule.getUpdated_at(),
                schedule.getSection()
        );
    }

    public static Schedule mapToSchedule(ScheduleResponseDTO scheduleResponseDTO){
        return new Schedule(
                scheduleResponseDTO.getId(),
                scheduleResponseDTO.getName(),
                scheduleResponseDTO.getSchedule(),
                scheduleResponseDTO.getCreated_at(),
                scheduleResponseDTO.getUpdated_at(),
                scheduleResponseDTO.getSection()
        );
    }
}
