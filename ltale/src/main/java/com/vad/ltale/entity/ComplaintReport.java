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

    @OneToOne
    @JoinColumn(name = "id_post")
    private Post post;

    @Column(name = "id_complaint")
    private int idComplaint;

    @Column(name = "date_created")
    private Date dateCreated;
}
