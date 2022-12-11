package com.vad.ltale.dao;

import com.vad.ltale.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Work, Integer> {
}
