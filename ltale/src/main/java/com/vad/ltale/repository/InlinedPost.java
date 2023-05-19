package com.vad.ltale.repository;

import com.vad.ltale.entity.Audio;
import com.vad.ltale.entity.Image;
import com.vad.ltale.entity.Post;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;
import java.util.List;

@Projection(name = "inlinePost", types = Post.class)
public interface InlinedPost {
    Long getId();
    Long getUser();
    List<Audio> getAudioList();
    Image getImage();
    int getCountLike();
    boolean isLiked();
    Date getDateCreated();
    Date getDateChanged();
}
