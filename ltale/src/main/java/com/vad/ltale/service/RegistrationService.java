package com.vad.ltale.service;

import com.vad.ltale.entity.User;
import com.vad.ltale.entity.UserRequest;

public interface RegistrationService {
    User save(UserRequest user);
}
