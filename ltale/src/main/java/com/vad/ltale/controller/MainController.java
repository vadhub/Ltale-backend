package com.vad.ltale.controller;

import com.vad.ltale.entity.User;
import com.vad.ltale.entity.UserRequest;
import com.vad.ltale.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final AuthService registrationService;

    @Autowired
    public MainController(AuthService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @ResponseBody
    @PostMapping("/registration")
    public User registrationPage(@RequestBody UserRequest user) {
        return registrationService.save(user);
    }

    @ResponseBody
    @GetMapping("/login")
    public User loginPage(@RequestParam String username) {
        return registrationService.getOne(username);
    }

    @GetMapping("/access-denied")
    public String deniedPage() {
        return "lol";
    }
}
