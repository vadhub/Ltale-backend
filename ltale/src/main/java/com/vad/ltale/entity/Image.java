package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_image")
    private int idImage;

    @Column(name="uri_image")
    private String imageUri;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="date_changed")
    private Date dateChanged;

    @Column(name="is_icon")
    private int isIcon;

    public Image() {
    }

    public Image(int idImage, String imageUri, Date dateCreated, Date dateChanged, int isIcon) {
        this.idImage = idImage;
        this.imageUri = imageUri;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
        this.isIcon = isIcon;
    }

    public Image(String imageUri, Date dateCreated, Date dateChanged, int isIcon) {
        this.imageUri = imageUri;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
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
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                ", isIcon=" + isIcon +
                '}';
    }
}
