package com.vad.ltale.controller;

import com.vad.ltale.entity.Limit;
import com.vad.ltale.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api-v1")
public class LimitController {

    private final LimitService limitService;

    @Autowired
    public LimitController(LimitService limitService) {
        this.limitService = limitService;
    }

    @GetMapping("/limit/{id}")
    public Limit getAll(@PathVariable Long id) {
        return limitService.getLimitByUserId(id);
    }
}
