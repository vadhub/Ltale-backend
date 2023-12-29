package com.vad.ltale.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "follow")
public class Follow {

    @EmbeddedId
    private FollowEmbeddedID followEmbeddedID;

    public Follow() {
    }

    public Follow(FollowEmbeddedID followEmbeddedID) {
        this.followEmbeddedID = followEmbeddedID;
    }

    public FollowEmbeddedID getFollowEmbeddedID() {
        return followEmbeddedID;
    }

    public void setFollowEmbeddedID(FollowEmbeddedID followEmbeddedID) {
        this.followEmbeddedID = followEmbeddedID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(followEmbeddedID, follow.followEmbeddedID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followEmbeddedID);
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followEmbeddedID=" + followEmbeddedID +
                '}';
    }
}
