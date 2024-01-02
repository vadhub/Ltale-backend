package com.vad.ltale.service;

import com.vad.ltale.entity.Post;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<Post> getAllPost(Long currentUserId, int page, int size);
}
