package com.vad.ltale.service;

import com.vad.ltale.entity.FileRequest;
import com.vad.ltale.entity.Post;
import com.vad.ltale.entity.PostRequest;
import com.vad.ltale.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //todo refactoring
        if (post.getImage() != null && !post.getImage().isEmpty()) {
            return postRepository.save(new Post(
                    fileStorage.saveAudio(new FileRequest(
                            post.getAudio(),
                            post.getDateCreated(),
                            post.getDateChanged())
                    ).getId(),
                    fileStorage.saveImage(new FileRequest(
                            post.getImage(),
                            post.getDateCreated(),
                            post.getDateChanged())
                    ).getIdImage(),
                    post.getUserId(),
                    post.getDateCreated(),
                    post.getDateChanged()
            ));
        } else {
            return postRepository.save(new Post(
                    fileStorage.saveAudio(new FileRequest(
                            post.getAudio(),
                            post.getDateCreated(),
                            post.getDateChanged())
                    ).getId(),
                    post.getUserId(),
                    post.getDateCreated(),
                    post.getDateChanged()
            ));
        }
    }

    @Override
    public Post getOne(Long id) {
        return null;
    }
}
