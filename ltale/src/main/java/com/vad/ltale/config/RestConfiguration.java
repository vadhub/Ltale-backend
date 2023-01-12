package com.vad.ltale.config;

import com.vad.ltale.entity.Audio;
import com.vad.ltale.entity.Image;
import com.vad.ltale.entity.Post;
import com.vad.ltale.entity.User;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Component
public class RestConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(User.class, Image.class, Audio.class, Post.class);
    }
}
