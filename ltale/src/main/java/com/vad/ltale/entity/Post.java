package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private int id;

    @Column(name = "audio_id")
    private Long audioId;

    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_changed")
    private Date dateChanged;


    public Post() {
    }

    public Post(Long audioId, Long imageId, Long userId, Date dateCreated, Date dateChanged) {
        this.audioId = audioId;
        this.imageId = imageId;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public Post(int id, Long audioId, Long imageId, Long userId, Date dateCreated, Date dateChanged) {
        this.id = id;
        this.audioId = audioId;
        this.imageId = imageId;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", audioId=" + audioId +
                ", imageId=" + imageId +
                ", userId=" + userId +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                '}';
    }
}
