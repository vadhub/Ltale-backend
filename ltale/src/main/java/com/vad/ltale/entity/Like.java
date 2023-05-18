package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "like_")
@IdClass(LikeID.class)
public class Like {

    @Id
    private Long userId;

    @Id
    private Long postId;

    public Like() {
    }

    public Long getIdPost() {
        return postId;
    }

    public void setIdPost(Long idPost) {
        this.postId = idPost;
    }

    public Long getIdUser() {
        return userId;
    }

    public void setIdUser(Long idUser) {
        this.userId = idUser;
    }
}
