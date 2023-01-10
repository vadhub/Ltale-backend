package com.vad.ltale.service;

import com.vad.ltale.entity.User;
import com.vad.ltale.entity.UserRequest;

public interface AuthService {
    User save(UserRequest user);

    User getOne(String username);
}
