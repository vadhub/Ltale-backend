package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "audio")
public class Audio {

    @Id
    @Column(name = "id_audio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uri_audio")
    private String uri;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_changed")
    private Date dateChanged;

    public Audio() {
    }

    public Audio(Long id, String uri, Date dateCreated, Date dateChanged) {
        this.id = id;
        this.uri = uri;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public Audio(String uri, Date dateCreated, Date dateChanged) {
        this.uri = uri;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
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

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateChanged=" + dateChanged +
                '}';
    }
}
