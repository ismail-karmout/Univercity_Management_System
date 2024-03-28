package com.umi.filiere.groupesection.mapper;

import com.umi.filiere.groupesection.dto.GroupResponseDTO;
import com.umi.filiere.groupesection.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
    public static GroupResponseDTO mapToGroupDto(Group group){
        return new GroupResponseDTO(
                group.getId(),
                group.getName(),
                group.getSlug(),
                group.getDescription(),
                group.getCreated_at(),
                group.getUpdated_at(),
                group.getDeletedAt(),
                group.getSection()
        );
    }
    public static Group mapToGroup(GroupResponseDTO groupResponseDTO){
        return new Group(groupResponseDTO.getId(),
                groupResponseDTO.getName(),
                groupResponseDTO.getDescription(),
                groupResponseDTO.getSlug(),
                groupResponseDTO.getCreated_at(),
                groupResponseDTO.getUpdated_at(),
                groupResponseDTO.getDeleted_at(),
                groupResponseDTO.getSection()
        );
    }


}
