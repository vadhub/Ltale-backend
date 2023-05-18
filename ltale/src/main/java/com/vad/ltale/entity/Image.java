package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_image")
    private Long idImage;

    @Column(name="uri_image")
    private String imageUri;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="date_changed")
    private Date dateChanged;

    public Image() {
    }

    public Image(String imageUri, Date dateCreated, Date dateChanged) {
        this.imageUri = imageUri;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }


    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
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
        return "Image{" +
                "idImage=" + idImage +
                ", imageUri='" + imageUri + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                '}';
    }
}
