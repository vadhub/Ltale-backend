package com.vad.ltale.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Date;

public class ImageRequest implements Serializable {

    private String imageUri;

    private Date dateCreated;

    private Date dateChanged;

    private MultipartFile file;

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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
