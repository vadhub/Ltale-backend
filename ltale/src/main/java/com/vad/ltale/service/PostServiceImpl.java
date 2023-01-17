package com.vad.ltale.service;

import com.vad.ltale.entity.Audio;
import com.vad.ltale.entity.FileRequest;
import com.vad.ltale.entity.Post;
import com.vad.ltale.entity.PostRequest;
import com.vad.ltale.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    private final FileStorage fileStorage;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, FileStorage fileStorage) {
        this.postRepository = postRepository;
        this.fileStorage = fileStorage;
    }

    @Override
    public Post save(PostRequest post) {
        System.out.println(post);
        //todo refactoring
        if (post.getImage() != null && !post.getImage().isEmpty()) {
            return postRepository.save(new Post(
                    List.of(fileStorage.saveAudio(
                            new FileRequest(
                                    post.getAudio(),
                                    post.getDateCreated(),
                                    post.getDateChanged())
                            )
                    ),
                    fileStorage.saveImage(
                            new FileRequest(
                                    post.getImage(),
                                    post.getDateCreated(),
                                    post.getDateChanged())
                    ),
                    post.getUserId(),
                    new Date(post.getDateCreated()),
                    new Date(post.getDateChanged())
                    )
            );
        } else {
            return postRepository.save(new Post(
                    List.of(fileStorage.saveAudio(
                            new FileRequest(
                                    post.getAudio(),
                                    post.getDateCreated(),
                                    post.getDateChanged())
                            )
                    ),
                    post.getUserId(),
                    new Date(post.getDateCreated()),
                    new Date(post.getDateChanged())
                    )
            );
        }
    }

    @Override
    public Post getOne(Long id) {
        return null;
    }
}
