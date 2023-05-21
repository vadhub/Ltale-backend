package com.vad.ltale.repository;

import com.vad.ltale.entity.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(excerptProjection = InlineLimit.class)
public interface LimitRepository extends JpaRepository<Limit, Long> {

    @Query("FROM Limit l WHERE l.userId= :userId")
    Optional<Limit> limitByUserId(@Param("userId") Long userId);
}
