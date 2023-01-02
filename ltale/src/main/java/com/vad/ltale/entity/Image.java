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

    public Image() {
    }

    public Image(int idImage, String imageUri) {
        this.idImage = idImage;
        this.imageUri = imageUri;
    }

    public Image(String imageUri) {
        this.imageUri = imageUri;
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

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}
