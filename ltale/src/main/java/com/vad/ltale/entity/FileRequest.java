package com.vad.ltale.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Date;

public class FileRequest implements Serializable {

    private MultipartFile file;

    private Date dateCreated;

    private Date dateChanged;

    public FileRequest() {
    }

    public FileRequest(MultipartFile file, Date dateCreated, Date dateChanged) {
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
        return "FileRequest{" +
                "file=" + file +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                '}';
    }
}
