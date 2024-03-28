package com.umi.researcherservice.service.impl;

import com.umi.researcherservice.entity.Professor;
import com.umi.researcherservice.entity.ProfessorRole;
import com.umi.researcherservice.entity.Role;
import com.umi.researcherservice.exception.ResourceNotFoundException;
import com.umi.researcherservice.repository.ProfessorRepository;
import com.umi.researcherservice.repository.ProfessorRoleRepository;
import com.umi.researcherservice.repository.RoleRepository;
import com.umi.researcherservice.service.ProfessorRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorRoleServiceImpl implements ProfessorRoleService {
    private ProfessorRoleRepository professorRoleRepository;
    private RoleRepository roleRepository;
    private ProfessorRepository professorRepository;
    @Override
    public void AddProfessorRole(Long professorId, Long roleId, String proof) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(()-> new ResourceNotFoundException("Professor is not exits with given id "+professorId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(()-> new ResourceNotFoundException("Role is not exits with given id "+roleId));

        ProfessorRole professorRole = new ProfessorRole();
        if ((professor != null) && (role != null) && (proof != null)){
            professorRole.setProfessor(professor);
            professorRole.setRole(role);
            professorRole.setProof(proof);
        }
        ProfessorRole savedProfessorRole = professorRoleRepository.save(professorRole);

    }
}
