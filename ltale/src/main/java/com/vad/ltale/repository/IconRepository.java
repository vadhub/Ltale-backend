package com.vad.ltale.repository;

import com.vad.ltale.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepository extends JpaRepository<Icon, Long> {
    Icon getIconByUserId(Long userId);
}
