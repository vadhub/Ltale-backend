package com.vad.ltale.repository;

import com.vad.ltale.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByUserId(int userId);
}
