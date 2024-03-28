package com.umi.filiere.groupesection.service.impl;

import com.umi.filiere.groupesection.dto.GroupRequestDTO;
import com.umi.filiere.groupesection.dto.GroupResponseDTO;
import com.umi.filiere.groupesection.entity.Group;
import com.umi.filiere.groupesection.mapper.GroupMapper;
import com.umi.filiere.groupesection.repository.GroupRepository;
import com.umi.filiere.groupesection.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    @Autowired
    public GroupMapper groupMapper;
    @Autowired
    public GroupRepository groupRepository;
    @Override
    public GroupResponseDTO createGroup(GroupResponseDTO groupResponseDTO) {
        Group group= GroupMapper.mapToGroup(groupResponseDTO);
        group.setCreated_at(LocalDateTime.now());
        Group savedGroup=groupRepository.save(group);
        return GroupMapper.mapToGroupDto(savedGroup);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Group %s not found !", id)));
    }
    @Override
    public GroupResponseDTO updateGroup(Long id, GroupRequestDTO groupRequestDTO) {
        Group group=Group.builder()
                .id(id)
                .name(groupRequestDTO.getName())
                .description((groupRequestDTO.getDescription()))
                .slug((groupRequestDTO.getSlug()))
                .created_at(groupRequestDTO.getCreated_at())
                .updated_at(LocalDateTime.now())
                .deletedAt(groupRequestDTO.getDeleted_at())
                .section(groupRequestDTO.getSection())
                .build();
        Group savedGroup=groupRepository.save(group);
        GroupResponseDTO groupResponseDTO=groupMapper.mapToGroupDto(savedGroup);
        return groupResponseDTO;
    }

    @Override
    public Boolean deleteGroup(Long id) {
        groupRepository.deleteById(id);
        return true;
    }
}
