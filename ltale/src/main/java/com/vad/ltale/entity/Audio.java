package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "audio")
public class Audio {

    @Id
    @Column(name = "id_audio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uri_audio")
    private String uri;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "date_create")
    private Timestamp dateCreate;


//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
//    @JoinColumn(name = "id_post")
//    private Post post;

    public Audio() {
    }


    public Audio(String uri, Long duration, Timestamp dateCreate) {
        this.uri = uri;
        this.duration = duration;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    //    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }


    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", duration=" + duration +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
