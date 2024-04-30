package com.vad.ltale.controller;

import com.vad.ltale.repository.ComplaintReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModerationController {

    private final ComplaintReportRepository complaintReportRepository;

    @Autowired
    public ModerationController(ComplaintReportRepository complaintReportRepository) {
        this.complaintReportRepository = complaintReportRepository;
    }

    @GetMapping("/moderation-posts")
    public String moderationPage(Model model) {
        model.addAttribute("reports", complaintReportRepository.findAll());
        return "index";
    }
}
