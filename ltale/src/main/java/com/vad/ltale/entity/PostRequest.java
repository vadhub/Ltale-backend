package com.vad.ltale.entity;

import java.sql.Date;

public class PostRequest {
    private FileRequest audio;

    private ImageRequest imageRequest;

    private Long userId;

    private Date dateCreated;

    private Date dateChanged;

    public FileRequest getAudio() {
        return audio;
    }

    public void setAudio(FileRequest audio) {
        this.audio = audio;
    }

    public ImageRequest getImageRequest() {
        return imageRequest;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        this.imageRequest = imageRequest;
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
}
