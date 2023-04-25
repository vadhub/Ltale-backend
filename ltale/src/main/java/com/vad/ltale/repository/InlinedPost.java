package com.vad.ltale.repository;

import com.vad.ltale.entity.Audio;
import com.vad.ltale.entity.Image;
import com.vad.ltale.entity.Post;
import com.vad.ltale.entity.User;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;
import java.util.List;

@Projection(name = "inlinePost", types = {Post.class})
public interface InlinedPost {
    Long getId();
    User getUser();
    List<Audio> getAudioList();
    Image getImage();
    Date getDateCreated();
    Date getDateChanged();
}
