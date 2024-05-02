package com.vad.ltale.controller;

import com.vad.ltale.entity.ComplaintReport;
import com.vad.ltale.repository.ComplaintReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModerationController {

    private final ComplaintReportRepository complaintReportRepository;

    @Autowired
    public ModerationController(ComplaintReportRepository complaintReportRepository) {
        this.complaintReportRepository = complaintReportRepository;
    }

    @GetMapping("/moderation-posts")
    public List<ComplaintReport> moderationPage() {
        return complaintReportRepository.findAllByOrderByDateCreatedDesc();
    }
}
