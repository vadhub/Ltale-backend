package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private int id;

    @Column(name = "title")
    private String titleMessage;

    @Column(name = "uri_message")
    private String uri;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "image_id")
    private int imageId;

    public Message() {
    }

    public Message(int id, String titleMessage, String uri, int user, int imageId) {
        this.id = id;
        this.titleMessage = titleMessage;
        this.uri = uri;
        this.userId = user;
        this.imageId = imageId;
    }

    public Message(String titleMessage, String uri, int user, int imageId) {
        this.titleMessage = titleMessage;
        this.uri = uri;
        this.userId = user;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleMessage() {
        return titleMessage;
    }

    public void setTitleMessage(String titleMessage) {
        this.titleMessage = titleMessage;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user) {
        this.userId = user;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", titleMessage='" + titleMessage + '\'' +
                ", uri='" + uri + '\'' +
                ", userId=" + userId +
                ", imageId=" + imageId +
                '}';
    }
}
