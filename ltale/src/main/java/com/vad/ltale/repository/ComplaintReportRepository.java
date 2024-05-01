package com.vad.ltale.repository;

import com.vad.ltale.entity.ComplaintReport;
import com.vad.ltale.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComplaintReportRepository extends JpaRepository<ComplaintReport, Long> {
    @Query("SELECT p " +
            "FROM Post p " +
            "WHERE p.id = :idPost")
    Post findPostId(@Param("idPost") Long idPost);
}
