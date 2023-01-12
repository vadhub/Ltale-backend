package com.vad.ltale.controller;

import com.vad.ltale.entity.Post;
import com.vad.ltale.entity.PostRequest;
import com.vad.ltale.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-v1")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseBody
    @PostMapping("/post/save")
    public Post savePost(@ModelAttribute PostRequest postRequest) {
        return postService.save(postRequest);
    }
}
