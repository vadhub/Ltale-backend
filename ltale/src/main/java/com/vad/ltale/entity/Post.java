package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="audio_id")
    private List<Audio> audio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="image_id")
    private Image image;

    @Column(name="user_id")
    private Long userId;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_changed")
    private Date dateChanged;

    public Post() {
    }

    public Post(List<Audio> audio, Image image, Long userId, Date dateCreated, Date dateChanged) {
        this.audio = audio;
        this.image = image;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public Post(List<Audio> audio, Long userId, Date dateCreated, Date dateChanged) {
        this.audio = audio;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public Post(int id, List<Audio> audio, Image image, Long userId, Date dateCreated, Date dateChanged) {
        this.id = id;
        this.audio = audio;
        this.image = image;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Audio> getAudio() {
        return audio;
    }

    public void setAudio(List<Audio> audio) {
        this.audio = audio;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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


}
