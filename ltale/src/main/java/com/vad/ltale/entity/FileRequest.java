package com.vad.ltale.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class FileRequest implements Serializable {

    private MultipartFile file;

    private Long dateCreated;

    private Long dateChanged;

    public FileRequest(MultipartFile file, Long dateCreated, Long dateChanged) {
        this.file = file;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public FileRequest(MultipartFile file) {
        this.file = file;
    }


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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
        return "FileRequest{" +
                "file=" + file +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                '}';
    }
}
