package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_message")
    private int id;

    @Column(name="title")
    private String titleMessage;

    @Column(name="uri_message")
    private String uri;

    @Column(name="user_id")
    private int user;

    public Message() {
    }

    public Message(int id, String titleMessage, String uri, int user) {
        this.id = id;
        this.titleMessage = titleMessage;
        this.uri = uri;
        this.user = user;
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

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", titleMessage='" + titleMessage + '\'' +
                ", uri='" + uri + '\'' +
                ", user=" + user +
                '}';
    }
}
