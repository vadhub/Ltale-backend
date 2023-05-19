package com.vad.ltale.controller;

import com.vad.ltale.entity.Like;
import com.vad.ltale.entity.LikeID;
import com.vad.ltale.entity.ResponseMessage;
import com.vad.ltale.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-v1")
public class LikesController {
    private final LikeRepository likeRepository;

    @Autowired
    public LikesController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @GetMapping("/likes")
    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    @PostMapping("/like")
    public ResponseEntity<Object> addLike(@RequestBody LikeID like) {
        String messageResponse = "";

        try {
            return ResponseEntity.status(HttpStatus.OK).body(likeRepository.save(new Like(like)));
        } catch (Exception e) {
            messageResponse = "Could not save: " + like + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @DeleteMapping("/delete-like")
    public String deleteLike(@RequestBody LikeID like) {
        likeRepository.delete(new Like(like));

        return "remove " + like;
    }
}
