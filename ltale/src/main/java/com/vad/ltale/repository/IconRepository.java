package com.vad.ltale.repository;

import com.vad.ltale.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IconRepository extends JpaRepository<Icon, Long> {

    @Query("FROM Icon i WHERE i.userId = :userId ORDER BY i.image.dateCreated DESC LIMIT 1")
    Optional<Icon> getIconByUserId(@Param("userId") Long userId);
}
