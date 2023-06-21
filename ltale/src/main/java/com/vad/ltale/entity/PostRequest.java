package com.vad.ltale.entity;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

public class PostRequest {
    private List<MultipartFile> audio;

    private List<Long> duration;

    private List<String> hashtags;

    private MultipartFile image;

    private Long userId;

    private Date dateCreated;

    private Date dateChanged;

    public List<MultipartFile> getListAudio() {
        return audio;
    }

    public void setAudio(List<MultipartFile> audio) {
        this.audio = audio;
    }

    public List<Long> getListDuration() {
        return duration;
    }

    public void setDuration(List<Long> duration) {
        this.duration = duration;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
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
        return "PostRequest{" +
                "audio=" + audio +
                ", image=" + image +
                ", userId=" + userId +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                '}';
    }
}
