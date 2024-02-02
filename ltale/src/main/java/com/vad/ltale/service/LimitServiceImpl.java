package com.vad.ltale.service;

import com.vad.ltale.entity.Limit;
import com.vad.ltale.repository.LimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;


@Service
public class LimitServiceImpl implements LimitService {

    private final LimitRepository limitRepository;

    @Autowired
    public LimitServiceImpl(LimitRepository limitRepository) {
        this.limitRepository = limitRepository;
    }

    @Override
    public Limit getLimitByUserId(Long userId) {
        Limit limit = limitRepository.limitByUserId(userId).get();

        Date now = new Date(System.currentTimeMillis());

        LocalDate firstDate = now.toLocalDate();
        LocalDate secondDate = limit.getDateUpdate().toLocalDate();

        if (firstDate.isAfter(secondDate)) {
            limit = limitRepository.save(new Limit(limit.getId(), limit.getUserId(), 180_000L, now));
        }

        return limit;
    }
}
