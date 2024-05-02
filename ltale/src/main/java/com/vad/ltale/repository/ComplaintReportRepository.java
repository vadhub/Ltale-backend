package com.vad.ltale.repository;

import com.vad.ltale.entity.ComplaintReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintReportRepository extends JpaRepository<ComplaintReport, Long> {
    List<ComplaintReport> findAllByOrderByDateCreatedDesc();
}
