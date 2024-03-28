package com.umi.researcherservice.service;

import com.umi.researcherservice.dto.PostDocDto;

import java.util.List;

public interface PostDocService {
    PostDocDto createPostDoc(PostDocDto postDocDto);
    PostDocDto getPostDocById(Long id);
    List<PostDocDto> getAllPostDoc();
    PostDocDto updatePostDoc(Long id, PostDocDto updatedPostDoc);
    void deletePostDoc(Long id);
}
