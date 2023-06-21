package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_hashtag")
    private Long idHashtag;

    @Column(name = "hashtag_name")
    private String hashtagName;

    public Hashtag() {
    }

    public Hashtag(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public Long getIdHashtag() {
        return idHashtag;
    }

    public void setIdHashtag(Long idHashtag) {
        this.idHashtag = idHashtag;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "idHashtag=" + idHashtag +
                ", hashtagName='" + hashtagName + '\'' +
                '}';
    }
}
