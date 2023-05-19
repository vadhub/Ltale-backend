package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "like_")
public class Like {

    @EmbeddedId
    LikeID likeID;

    public Like() {
    }

    public Like(LikeID likeID) {
        this.likeID = likeID;
    }

    public LikeID getLikeID() {
        return likeID;
    }

    public void setLikeID(LikeID likeID) {
        this.likeID = likeID;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeID=" + likeID +
                '}';
    }
}
