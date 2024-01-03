package com.vad.ltale.controller;

import com.vad.ltale.entity.LikeID;
import com.vad.ltale.entity.Post;
import com.vad.ltale.repository.LikeRepository;
import com.vad.ltale.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api-v1")
public class PostController {

    private final PostService postService;
    private final LikeRepository likeRepository;

    @Autowired
    public PostController(PostService postService, LikeRepository likeRepository) {
        this.postService = postService;
        this.likeRepository = likeRepository;
    }

    @GetMapping("/posts")
    public List<Post> getAllPost(@RequestParam Long currentUserId, @RequestParam int page) {
        return postService.getAllPost(currentUserId, page, 20).stream().peek(post -> {
            if (likeRepository.findById(new LikeID(currentUserId, post.getId())).isPresent()) {
                post.setIsLiked(1);
            }
        }).toList();
    }

    @GetMapping("/posts/user")
    public List<Post> getAllPostCurrentUser(@RequestParam Long userId, @RequestParam Long currentUserId, @RequestParam int page) {
        return postService.getAllPost(currentUserId, page, 20).stream().filter(post -> Objects.equals(post.getUser(), userId)).peek(post -> {
            if (likeRepository.findById(new LikeID(currentUserId, post.getId())).isPresent()) {
                post.setIsLiked(1);
            }
        }).toList();
    }
}
