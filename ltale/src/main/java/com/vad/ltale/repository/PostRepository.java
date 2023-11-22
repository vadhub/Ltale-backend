package com.vad.ltale.repository;

import com.vad.ltale.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = InlinedPost.class)
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p " +
            "FROM Post p inner join p.hashtags h " +
            "on h.idPost = p.id " +
            "where h.hashtagName LIKE %:text% " +
            "or p.nikName LIKE %:text%")
    List<Post> findAllPostByText(@Param("text") String text);

    List<Post> findAllByUserId(Long userId);
}
