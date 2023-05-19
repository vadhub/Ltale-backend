package com.vad.ltale.entity;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class LikeID implements Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    private Long userId;

    private Long postId;

    public LikeID() {
    }

    public LikeID(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "LikeEmbed{" +
                "userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
