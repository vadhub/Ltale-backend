package com.vad.ltale.entity;

import jakarta.persistence.*;


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


//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
//    @JoinColumn(name = "id_post")
//    private Post post;

    public Audio() {
    }


    public Audio(String uri, Long duration) {
        this.uri = uri;
        this.duration = duration;
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
                '}';
    }
}
