package com.vad.ltale.repository;

import com.vad.ltale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("FROM User u WHERE u.username = :username")
    Optional<User> findByFirstName(@Param("username") String username);
}
