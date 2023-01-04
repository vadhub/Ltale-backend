package com.vad.ltale.repository;

import com.vad.ltale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("FROM User u WHERE u.firstName = :firstName")
    User findByFirstName(@Param("firstName") String firstName);
}
