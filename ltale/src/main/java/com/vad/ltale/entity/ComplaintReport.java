package com.vad.ltale.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "complaint_report")
public class ComplaintReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_post")
    private Long idPost;

    @Column(name = "id_complaint")
    private int idComplaint;

    @Column(name = "date_created")
    private Date dateCreated;

    public ComplaintReport() {
    }

    public ComplaintReport(Long idPost, int idComplaint, Date dateCreated) {
        this.idPost = idPost;
        this.idComplaint = idComplaint;
        this.dateCreated = dateCreated;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(int idComplaint) {
        this.idComplaint = idComplaint;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


}
