package com.vad.ltale.service;

import com.vad.ltale.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPost(Long currentUserId);
}
