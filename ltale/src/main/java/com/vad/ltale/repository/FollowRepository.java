package com.vad.ltale.repository;

import com.vad.ltale.entity.Follow;
import com.vad.ltale.entity.FollowEmbeddedID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, FollowEmbeddedID> {
}
