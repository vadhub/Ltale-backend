package com.vad.ltale.entity;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FollowEmbeddedID implements Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    private Long followerId;
    private Long followedId;

    public FollowEmbeddedID() {
    }

    public FollowEmbeddedID(Long followerId, Long followedId) {
        this.followerId = followerId;
        this.followedId = followedId;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowEmbeddedID that = (FollowEmbeddedID) o;
        return Objects.equals(followerId, that.followerId) && Objects.equals(followedId, that.followedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, followedId);
    }

    @Override
    public String toString() {
        return "FollowEmbeddedID{" +
                "followerId=" + followerId +
                ", followedId=" + followedId +
                '}';
    }
}
