package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_image")
    private int idImage;

    @Column(name="uri_image")
    private String imageUri;

    @Column(name="user_id")
    private int userId;

    @Column(name="is_icon_user")
    private int isIcon;

    public Image() {
    }

    public Image(int idImage, String imageUri, int userId, int isIcon) {
        this.idImage = idImage;
        this.imageUri = imageUri;
        this.userId = userId;
        this.isIcon = isIcon;
    }

    public Image(String imageUri, int userId, int isIcon) {
        this.imageUri = imageUri;
        this.userId = userId;
        this.isIcon = isIcon;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }


    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsIcon() {
        return isIcon;
    }

    public void setIsIcon(int isIcon) {
        this.isIcon = isIcon;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", imageUri='" + imageUri + '\'' +
                ", userId=" + userId +
                ", isIcon=" + isIcon +
                '}';
    }
}
