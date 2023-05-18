package com.vad.ltale.repository;

import com.vad.ltale.entity.Like;
import com.vad.ltale.entity.LikeID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikeRepository extends JpaRepository<Like, LikeID> {
}
