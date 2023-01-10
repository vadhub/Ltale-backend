package com.vad.ltale.repository;

import com.vad.ltale.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {
//    List<Image> findAllByUserId(int userId);

//    @Query("FROM Image i WHERE i.userId = :userId AND i.isIcon = 1")
//    Optional<Image> findByUserIdAndIsIcon(@Param("userId") int userId);
}
