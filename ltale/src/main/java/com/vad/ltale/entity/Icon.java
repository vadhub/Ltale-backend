package com.vad.ltale.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "icons")
public class Icon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_icon")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="image_id")
    private Image image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    public Icon() {
    }

    public Icon(Long id, Image image, User user) {
        this.id = id;
        this.image = image;
        this.user = user;
    }

    public Icon(Image image, User user) {
        this.image = image;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Icon{" +
                "id=" + id +
                ", image=" + image +
                ", user=" + user +
                '}';
    }
}
