package com.vad.ltale.service;

import com.vad.ltale.entity.*;
import com.vad.ltale.repository.PostAndAudioRepository;
import com.vad.ltale.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostAndAudioRepository postAndAudioRepository;

    private final FileStorage fileStorage;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostAndAudioRepository postAndAudioRepository, FileStorage fileStorage) {
        this.postRepository = postRepository;
        this.postAndAudioRepository = postAndAudioRepository;
        this.fileStorage = fileStorage;
    }

    @Override
    public Post save(PostRequest post) {
        //todo refactoring
        Post response;
        if (post.getImage() != null && !post.getImage().isEmpty()) {

            response = postRepository.save(new Post(
                            fileStorage.saveImage(
                                    new FileRequest(
                                            post.getImage(),
                                            post.getDateCreated(),
                                            post.getDateChanged())
                            ).getIdImage(),
                            post.getUserId(),
                            new Date(post.getDateCreated()),
                            new Date(post.getDateChanged())
                    )
            );

        } else {
            response = postRepository.save(new Post(
                            post.getUserId(),
                            new Date(post.getDateCreated()),
                            new Date(post.getDateChanged())
                    )
            );
        }

        Post finalResponse = response;
        post.getAudio().stream().map(
                mb -> new PostAndAudio(finalResponse.getId(), fileStorage.saveAudio(new FileRequest(mb, post.getDateCreated(), post.getDateChanged())).getId())
        ).forEach(postAndAudioRepository::save);

        return response;
    }

    @Override
    public NestedPost getOne(Long id) {
        var post = postRepository.findById(id).orElse(new Post());
        List<Long> ids = postAndAudioRepository.getPostAndAudiosByPostId(id)
                .stream().map(PostAndAudio::getAudioId).toList();

        return new NestedPost(
                fileStorage.getImageById(post.getImageId()),
                post.getDateCreated(),
                post.getDateChanged(),
                fileStorage.getAudiosById(ids)
        );
    }
}
