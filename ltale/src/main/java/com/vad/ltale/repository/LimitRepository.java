package com.vad.ltale.repository;

import com.vad.ltale.entity.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LimitRepository extends JpaRepository<Limit, Long> {

    @Query("FROM Limit l WHERE l.userId= :userId")
    Optional<Limit> limitByUserId(@Param("userId") Long userId);
}
