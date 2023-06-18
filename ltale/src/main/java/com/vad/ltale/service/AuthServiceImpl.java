package com.vad.ltale.service;

import com.vad.ltale.entity.Limit;
import com.vad.ltale.entity.Role;
import com.vad.ltale.entity.User;
import com.vad.ltale.entity.UserRequest;
import com.vad.ltale.repository.LimitRepository;
import com.vad.ltale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final LimitRepository limitRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, LimitRepository limitRepository) {
        this.userRepository = userRepository;
        this.limitRepository = limitRepository;
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

        User saved = userRepository.save(user);

        limitRepository.save(new Limit(saved.getId(), 60_000L, new Date(System.currentTimeMillis())));

        return saved;
    }

    @Override
    public User getOne(String username) {
        return userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("username not found: " + username));
    }
}
