package com.umi.researcherservice.service.impl;

import com.umi.researcherservice.dto.RoleDto;
import com.umi.researcherservice.entity.Role;
import com.umi.researcherservice.entity.Role;
import com.umi.researcherservice.entity.Role;
import com.umi.researcherservice.exception.ResourceNotFoundException;
import com.umi.researcherservice.mapper.RoleMapper;
import com.umi.researcherservice.mapper.RoleMapper;
import com.umi.researcherservice.mapper.RoleMapper;
import com.umi.researcherservice.repository.RoleRepository;
import com.umi.researcherservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role Role = RoleMapper.mapToRole(roleDto);
        Role createdRole = roleRepository.save(Role);
        return RoleMapper.mapToRoleDto(createdRole);
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Role is not exits with given id "+id));
        return RoleMapper.mapToRoleDto(role);
    }

    @Override
    public List<RoleDto> getAllRole() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map((role)-> RoleMapper.mapToRoleDto(role))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto updateRole(Long id, RoleDto updatedRole) {
        Role role = roleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Role is not exits with given id "+id));
        if(updatedRole.getName()!= null) role.setName(updatedRole.getName());
        if(updatedRole.getProfessorRoles() != null) role.setProfessorRoles(updatedRole.getProfessorRoles());

        Role savedRole = roleRepository.save(role);
        return RoleMapper.mapToRoleDto(savedRole);
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Role is not exits with given id "+id));
        roleRepository.deleteById(id);
    }
}
