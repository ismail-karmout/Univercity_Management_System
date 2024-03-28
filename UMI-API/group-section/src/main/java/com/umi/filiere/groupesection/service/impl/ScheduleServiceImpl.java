package com.umi.filiere.groupesection.service.impl;

import com.umi.filiere.groupesection.dto.ScheduleRequestDTO;
import com.umi.filiere.groupesection.dto.ScheduleResponseDTO;
import com.umi.filiere.groupesection.entity.Schedule;
import com.umi.filiere.groupesection.mapper.ScheduleMapper;
import com.umi.filiere.groupesection.repository.ScheduleRepository;
import com.umi.filiere.groupesection.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    public ScheduleMapper scheduleMapper;
    @Autowired
    public ScheduleRepository scheduleRepository;
    @Override
    public ScheduleResponseDTO createSchedule(ScheduleResponseDTO scheduleResponseDTO) {
        Schedule schedule= ScheduleMapper.mapToSchedule(scheduleResponseDTO);
        schedule.setCreated_at(LocalDateTime.now());
        Schedule savedSchedule=scheduleRepository.save(schedule);
        return ScheduleMapper.mapToScheduleDTO(savedSchedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Schedule %s not found !", id)));
    }

    @Override
    public Schedule getScheduleBySectionId(Long Id) {
        return scheduleRepository.findScheduleBySectionId(Id);
    }

    @Override
    public ScheduleResponseDTO updateSchedule(Long id, ScheduleRequestDTO scheduleRequestDTO) {
        Schedule schedule=Schedule.builder()
                .id(id)
                .name(scheduleRequestDTO.getName())
                .schedule(scheduleRequestDTO.getSchedule())
                .created_at(scheduleRequestDTO.getCreated_at())
                .updated_at(LocalDateTime.now())
                .section(scheduleRequestDTO.getSection())
                .build();
        Schedule savedSchedule=scheduleRepository.save(schedule);
        ScheduleResponseDTO scheduleResponseDTO=scheduleMapper.mapToScheduleDTO((savedSchedule));
        return scheduleResponseDTO;
    }

    @Override
    public Boolean deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
        return true;
    }
}
