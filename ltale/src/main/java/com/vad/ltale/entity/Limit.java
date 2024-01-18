package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "limited")
public class Limit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_limited")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "time_")
    private Long time;

    @Column(name = "date_update")
    private Date dateUpdate;

    public Limit(Long id, Long userId, Long limit, Date dateUpdate) {
        this.id = id;
        this.userId = userId;
        this.time = limit;
        this.dateUpdate = dateUpdate;
    }

    public Limit(Long userId, Long limit, Date dateUpdate) {
        this.userId = userId;
        this.time = limit;
        this.dateUpdate = dateUpdate;
    }

    public Limit() {
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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
                ", limit=" + time +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
