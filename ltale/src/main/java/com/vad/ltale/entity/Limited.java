package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "limited")
public class Limited {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_limited")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "limit")
    private Long limit;

    @Column(name = "date_update")
    private Date dateUpdate;

    public Limited(Long id, Long userId, Long limit, Date dateUpdate) {
        this.id = id;
        this.userId = userId;
        this.limit = limit;
        this.dateUpdate = dateUpdate;
    }

    public Limited(Long userId, Long limit, Date dateUpdate) {
        this.userId = userId;
        this.limit = limit;
        this.dateUpdate = dateUpdate;
    }

    public Limited() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public String toString() {
        return "Limited{" +
                "id=" + id +
                ", userId=" + userId +
                ", limit=" + limit +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
