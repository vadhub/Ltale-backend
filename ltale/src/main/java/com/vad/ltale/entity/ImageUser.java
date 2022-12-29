package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name="image_user")
public class ImageUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_image_user")
    private int idImage;

    @Column(name="user_id")
    private int userId;

    @Column(name="image_uri")
    private String imageUri;

    public ImageUser() {
    }

    public ImageUser(int idImage, int userId, String imageUri) {
        this.idImage = idImage;
        this.userId = userId;
        this.imageUri = imageUri;
    }

    public ImageUser(int userId, String imageUri) {
        this.userId = userId;
        this.imageUri = imageUri;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", userId=" + userId +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
