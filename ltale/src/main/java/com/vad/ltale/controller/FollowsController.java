package com.vad.ltale.controller;

import com.vad.ltale.entity.*;
import com.vad.ltale.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api-v1")
public class FollowsController {

    private final FollowRepository followRepository;

    @Autowired
    public FollowsController(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @GetMapping("/subscribers")
    public Long getSubscribers(@Param("userId") Long userId) {
        return followRepository.findAll().stream().filter(follow -> Objects.equals(follow.getFollowEmbeddedID().getFollowedId(), userId)).count();
    }

    @GetMapping("/is_subscriber")
    public boolean isSubscriber(@Param("follower") Long follower, @Param("followed") Long followed) {
        return followRepository.findById(new FollowEmbeddedID(follower, followed)).isPresent();
    }

    @PostMapping("/subscribe")
    public ResponseEntity<Object> addLike(@RequestBody FollowEmbeddedID followEmbeddedID) {
        String messageResponse = "";

        try {
            return ResponseEntity.status(HttpStatus.OK).body(followRepository.save(new Follow(followEmbeddedID)));
        } catch (Exception e) {
            messageResponse = "Could not save: " + followEmbeddedID + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @DeleteMapping("/unsubscribe")
    public String deleteLike(@RequestBody FollowEmbeddedID followEmbeddedID) {
        followRepository.delete(new Follow(followEmbeddedID));

        return "remove " + followEmbeddedID;
    }
}
