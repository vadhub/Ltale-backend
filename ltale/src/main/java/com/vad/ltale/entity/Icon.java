package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "icons")
public class Icon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_icon")
    private Long id;

    @Column(name="image_id")
    private Long imageId;

    @Column(name="user_id")
    private Long userId;

    public Icon() {
    }

    public Icon(Long imageId, Long userId) {
        this.imageId = imageId;
        this.userId = userId;
    }

    public Icon(Long id, Long imageId, Long userId) {
        this.id = id;
        this.imageId = imageId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Icon{" +
                "id=" + id +
                ", imageId=" + imageId +
                ", userId=" + userId +
                '}';
    }
}
