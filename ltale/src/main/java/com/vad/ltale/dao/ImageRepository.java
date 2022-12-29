package com.vad.ltale.dao;

import com.vad.ltale.entity.ImageUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageUser, Integer> {
}
