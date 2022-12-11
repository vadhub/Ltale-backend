package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name="message")
public class Work {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_message")
    private int id;

    @Column(name="title")
    private String nameWork;

    @Column(name="uri_message")
    private String uri;

    @Column(name="user_id")
    private int id_user;

    public Work() {
    }

    public Work(int id, String nameWork, String uri, int id_user) {
        this.id = id;
        this.nameWork = nameWork;
        this.uri = uri;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameWork() {
        return nameWork;
    }

    public void setNameWork(String nameWork) {
        this.nameWork = nameWork;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", nameWork='" + nameWork + '\'' +
                ", uri='" + uri + '\'' +
                ", id_user=" + id_user +
                '}';
    }
}
