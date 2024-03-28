package com.umi.researcherservice.service.impl;

import com.umi.researcherservice.dto.PostDocDto;
import com.umi.researcherservice.entity.PostDoc;
import com.umi.researcherservice.entity.PostDoc;
import com.umi.researcherservice.entity.PostDoc;
import com.umi.researcherservice.entity.PostDoc;
import com.umi.researcherservice.exception.ResourceNotFoundException;
import com.umi.researcherservice.feign.LaboServiceClient;
import com.umi.researcherservice.mapper.PostDocMapper;
import com.umi.researcherservice.mapper.PostDocMapper;
import com.umi.researcherservice.mapper.PostDocMapper;
import com.umi.researcherservice.mapper.PostDocMapper;
import com.umi.researcherservice.model.Labo;
import com.umi.researcherservice.model.Team;
import com.umi.researcherservice.repository.PostDocRepository;
import com.umi.researcherservice.service.PostDocService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostDocServiceImpl implements PostDocService {
    private PostDocRepository postDocRepository;
    private LaboServiceClient laboServiceClient;
    @Override
    public PostDocDto createPostDoc(PostDocDto postDocDto) {
        PostDoc postDoc = PostDocMapper.mapToPostDoc(postDocDto);
        PostDoc createdPostDoc = postDocRepository.save(postDoc);
        return PostDocMapper.mapToPostDocDto(createdPostDoc);
    }

    @Override
    public PostDocDto getPostDocById(Long id) {
        PostDoc postDoc = postDocRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PostDoc is not exits with given id "+id));

        if(postDoc.getLaboId()!= null){
            postDoc.setLabo(laboServiceClient.getLaboById(postDoc.getLaboId()));
        }
        if(postDoc.getTeamId()!= null){
            postDoc.setTeam(laboServiceClient.getTeamById(postDoc.getTeamId()));
        }

        return PostDocMapper.mapToPostDocDto(postDoc);
    }

    @Override
    public List<PostDocDto> getAllPostDoc() {
        List<PostDoc> postDocs = postDocRepository.findAll();

        postDocs.forEach( postDoc -> {
            if(postDoc.getLaboId() != null) {
                Labo labo = laboServiceClient.getLaboById(postDoc.getLaboId());
                postDoc.setLabo(labo);
            }

            if(postDoc.getTeamId() != null) {
                Team team = laboServiceClient.getTeamById(postDoc.getTeamId());
                postDoc.setTeam(team);
            }

        });

        return postDocs.stream().map((postDoc)-> PostDocMapper.mapToPostDocDto(postDoc))
                .collect(Collectors.toList());
    }

    @Override
    public PostDocDto updatePostDoc(Long id, PostDocDto updatedPostDoc) {
        PostDoc postDoc = postDocRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PostDoc is not exits with given id "+id));
        if(updatedPostDoc.getFirstname()!= null) postDoc.setFirstname(updatedPostDoc.getFirstname());
        if(updatedPostDoc.getLastname()!= null) postDoc.setLastname(updatedPostDoc.getLastname());
        if(updatedPostDoc.getPhone()!= null) postDoc.setPhone(updatedPostDoc.getPhone());
        if(updatedPostDoc.getEmail()!= null) postDoc.setEmail(updatedPostDoc.getEmail());

        PostDoc savedPostDoc = postDocRepository.save(postDoc);
        return PostDocMapper.mapToPostDocDto(savedPostDoc);
    }

    @Override
    public void deletePostDoc(Long id) {
        PostDoc postDoc = postDocRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("PostDoc is not exits with given id "+id));
        postDocRepository.deleteById(id);
    }
}
