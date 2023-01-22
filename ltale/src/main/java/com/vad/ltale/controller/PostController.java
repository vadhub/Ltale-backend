package com.vad.ltale.controller;

import com.vad.ltale.entity.*;
import com.vad.ltale.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

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
    public ResponseEntity<Post> savePost(@ModelAttribute PostRequest postRequest) {
        return ResponseEntity.ok().body(postService.save(postRequest));
    }


    @GetMapping("/poste/{idPost}")
    public NestedPost getPost(@PathVariable Long idPost) {
        List l = List.of(
                new Audio("4344", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())),
                new Audio("4344", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()))
        );
        return new NestedPost(
                new Image("4344", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())),
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
                l
        );
    }
}
