package com.vad.ltale.entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PostRequest {
    private List<MultipartFile> audio;

    private MultipartFile image;

    private Long userId;

    private Long dateCreated;

    private Long dateChanged;

    public List<MultipartFile> getAudio() {
        return audio;
    }

    public void setAudio(List<MultipartFile> audio) {
        this.audio = audio;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Long dateChanged) {
        this.dateChanged = dateChanged;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "audio=" + audio +
                ", image=" + image +
                ", userId=" + userId +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                '}';
    }
}
