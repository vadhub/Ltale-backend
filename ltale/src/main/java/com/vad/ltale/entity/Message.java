package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private int id;

    @Column(name = "uri_audio")
    private String uri;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_changed")
    private Date dateChanged;

    @Column(name = "image_id_")
    private int imageId;

    public Message() {
    }

    public Message(int id, String uri, Date dateCreated, Date dateChanged, int imageId) {
        this.id = id;
        this.uri = uri;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
        this.imageId = imageId;
    }

    public Message(String uri, Date dateCreated, Date dateChanged, int imageId) {
        this.uri = uri;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
        return "Message{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                ", imageId=" + imageId +
                '}';
    }
}
