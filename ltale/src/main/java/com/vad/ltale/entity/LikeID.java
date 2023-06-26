package com.vad.ltale.entity;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeID likeID = (LikeID) o;
        return Objects.equals(userId, likeID.userId) && Objects.equals(postId, likeID.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, postId);
    }

    @Override
    public String toString() {
        return "LikeEmbed{" +
                "userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
