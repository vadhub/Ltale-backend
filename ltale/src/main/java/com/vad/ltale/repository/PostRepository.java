package com.vad.ltale.repository;

import com.vad.ltale.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Message> findAllByUserId(int userId);
}
