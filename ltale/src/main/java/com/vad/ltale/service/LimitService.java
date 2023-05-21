package com.vad.ltale.service;

import com.vad.ltale.entity.Limit;

public interface LimitService {
    Limit getLimitByUserId(Long userId);
}
