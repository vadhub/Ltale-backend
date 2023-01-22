package com.vad.ltale.service;

import com.vad.ltale.entity.NestedPost;
import com.vad.ltale.entity.Post;
import com.vad.ltale.entity.PostRequest;

import java.util.List;

public interface PostService {
    Post save(PostRequest post);

    NestedPost getOne(Long id);

    List<NestedPost> getByUserId(Long userId);
}
