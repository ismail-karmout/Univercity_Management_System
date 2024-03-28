package com.umi.researcherservice.mapper;

import com.umi.researcherservice.dto.PostDocDto;
import com.umi.researcherservice.entity.PostDoc;

public class PostDocMapper {
    public static PostDocDto mapToPostDocDto(PostDoc postDoc){
        PostDocDto postDocDto = new PostDocDto();
        postDocDto.setId(postDoc.getId());
        postDocDto.setFirstname(postDoc.getFirstname());
        postDocDto.setLastname(postDoc.getLastname());
        postDocDto.setPhone(postDoc.getPhone());
        postDocDto.setEmail(postDoc.getEmail());
        postDocDto.setLaboId(postDoc.getLaboId());
        postDocDto.setLabo(postDoc.getLabo());
        postDocDto.setTeamId(postDoc.getTeamId());
        postDocDto.setTeam(postDoc.getTeam());
        postDocDto.setCreated_at(postDoc.getCreated_at());
        postDocDto.setUpdated_at(postDoc.getUpdated_at());
        return postDocDto;
    }

    public static PostDoc mapToPostDoc(PostDocDto postDocDto){
        PostDoc postDoc = new PostDoc();
        postDoc.setId(postDocDto.getId());
        postDoc.setFirstname(postDocDto.getFirstname());
        postDoc.setLastname(postDocDto.getLastname());
        postDoc.setPhone(postDocDto.getPhone());
        postDoc.setEmail(postDocDto.getEmail());
        postDoc.setLaboId(postDoc.getLaboId());
        postDoc.setLabo(postDoc.getLabo());
        postDoc.setTeamId(postDoc.getTeamId());
        postDoc.setTeam(postDoc.getTeam());
        postDoc.setCreated_at(postDocDto.getCreated_at());
        postDoc.setUpdated_at(postDocDto.getUpdated_at());
        return postDoc;
    }
}
