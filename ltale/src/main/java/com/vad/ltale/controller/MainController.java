package com.vad.ltale.controller;

import com.vad.ltale.entity.User;
import com.vad.ltale.entity.UserRequest;
import com.vad.ltale.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final RegistrationService registrationService;

    @Autowired
    public MainController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @ResponseBody
    @PostMapping("/registration")
    public String registrationPage(@RequestBody UserRequest user) {
        return registrationService.save(user).toString();
    }

    @GetMapping("/access-denied")
    public String deniedPage() {
        return "lol";
    }
}
