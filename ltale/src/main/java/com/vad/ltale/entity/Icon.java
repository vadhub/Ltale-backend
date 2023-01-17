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

    @Column(name="user_id")
    private Long userId;

    public Icon() {
    }

    public Icon(Long id, Image image, Long userId) {
        this.id = id;
        this.image = image;
        this.userId = userId;
    }

    public Icon(Image image, Long userId) {
        this.image = image;
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Icon{" +
                "id=" + id +
                ", image=" + image +
                ", user=" + userId +
                '}';
    }
}
