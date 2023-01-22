package com.vad.ltale.service;

import com.vad.ltale.entity.NestedPost;
import com.vad.ltale.entity.Post;
import com.vad.ltale.entity.PostRequest;

public interface PostService {
    Post save(PostRequest post);

    NestedPost getOne(Long id);
}
