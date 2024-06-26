package com.vad.ltale.controller;

import com.vad.ltale.entity.User;
import com.vad.ltale.entity.UserRequest;
import com.vad.ltale.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public ResponseEntity<Object> registrationPage(@RequestBody UserRequest user) {
        User u = null;
        try {
            u = registrationService.save(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(u);
    }

    @ResponseBody
    @GetMapping("/login")
    public ResponseEntity<User> loginPage(@RequestParam String username) {

        User u = null;

        try {
            u = registrationService.getOne(username);
            u.setPassword("");

        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok(u);
    }

    @ResponseBody
    @PutMapping("/change")
    public ResponseEntity<Object> changeNik(@RequestParam String newNik, @RequestParam Long id) {
        User u = null;
        try {
            u = registrationService.getOneById(id, newNik);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(u);
    }

    @GetMapping("/access-denied")
    public String deniedPage() {
        return "lol";
    }
}
