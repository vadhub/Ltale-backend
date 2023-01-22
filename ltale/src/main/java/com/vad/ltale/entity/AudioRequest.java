package com.vad.ltale.entity;

import org.springframework.web.multipart.MultipartFile;

public class AudioRequest {
    private MultipartFile file;

    private Long duration;

    public AudioRequest(MultipartFile file, Long duration) {
        this.file = file;
        this.duration = duration;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AudioRequest{" +
                "file=" + file +
                ", duration=" + duration +
                '}';
    }
}
