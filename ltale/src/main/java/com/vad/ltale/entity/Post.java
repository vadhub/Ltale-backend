package com.vad.ltale.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_changed")
    private Date dateChanged;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "id_post")
    private List<Audio> audioList;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "id_post_")
    private List<Hashtag> hashtags;

    @Formula("(SELECT count(i.user_id) FROM like_ i WHERE i.post_id = id_post)")
    private int countLike;

    private int isLiked;

    @Formula("(SELECT i.username FROM user i WHERE i.id_user = user_id)")
    private String nikName;

    public Post() {
    }

    public Post(Long userId, Image image, List<Audio> audioList, Date dateCreated, Date dateChanged, List<Hashtag> hashtags) {
        this.userId = userId;
        this.image = image;
        this.audioList = audioList;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
        this.hashtags = hashtags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
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

    public int getCountLike() {
        return countLike;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public boolean isLiked() {
        return isLiked > 0;
    }

    public List<Audio> getAudioList() {
        return audioList;
    }

    public void setAudioList(List<Audio> audioList) {
        this.audioList = audioList;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public String getNikName() {
        return nikName;
    }
}
