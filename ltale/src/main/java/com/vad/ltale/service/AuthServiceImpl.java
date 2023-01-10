package com.vad.ltale.service;

import com.vad.ltale.entity.Role;
import com.vad.ltale.entity.User;
import com.vad.ltale.entity.UserRequest;
import com.vad.ltale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRequest userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        User user = new User(
                userRequest.getUsername(),
                userRequest.getEmail(),
                new BCryptPasswordEncoder(12).encode(userRequest.getPassword()),
                1,
                Role.USER);
        return userRepository.save(user);
    }

    @Override
    public User getOne(String username) {
        return userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("username not found: " + username));
    }
}
