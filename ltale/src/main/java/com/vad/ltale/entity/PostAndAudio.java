package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "post_and_audio")
public class PostAndAudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pa")
    private Long id;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "audio_id")
    private Long audioId;

    public PostAndAudio() {
    }

    public PostAndAudio(Long postId, Long audioId) {
        this.postId = postId;
        this.audioId = audioId;
    }

    public PostAndAudio(Long id, Long postId, Long audioId) {
        this.id = id;
        this.postId = postId;
        this.audioId = audioId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }
}
