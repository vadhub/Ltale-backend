package com.vad.ltale.repository;

import com.vad.ltale.entity.Like;
import com.vad.ltale.entity.LikeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface LikeRepository extends JpaRepository<Like, LikeID> {
    @Query("SELECT count(*) FROM Like i WHERE i.postId = :postId")
    int countAllBy(@Param("postId") Long postId);

    @Query("FROM Like i WHERE i.postId = :postId AND i.userId = :userId")
    Optional<Like> findLikeByIdPostAndUserId(@Param("postId") Long postId, @Param("userId") Long userId);
}
