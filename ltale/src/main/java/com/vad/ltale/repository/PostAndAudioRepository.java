package com.vad.ltale.repository;

import com.vad.ltale.entity.PostAndAudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostAndAudioRepository extends JpaRepository<PostAndAudio, Long> {
    List<PostAndAudio> getPostAndAudiosByPostId (Long postId);
}
