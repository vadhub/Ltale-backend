package com.vad.ltale.entity;


import java.sql.Date;
import java.util.List;

public class NestedPost {

    private Image image;
    private Date dateCreated;
    private Date dateChanged;
    private List<Audio> audios;

    public NestedPost(Image image, Date dateCreated, Date dateChanged, List<Audio> audios) {
        this.image = image;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
        this.audios = audios;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }
}
