package com.vad.ltale.service;

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

        if (post.getImageRequest() != null) {
            return postRepository.save(new Post(
                    fileStorage.saveAudio(post.getAudio()).getId(),
                    fileStorage.saveImage(post.getImageRequest()).getIdImage(),
                    post.getUserId(),
                    post.getDateCreated(),
                    post.getDateChanged()
            ));
        } else {
            return postRepository.save(new Post(
                    fileStorage.saveAudio(post.getAudio()).getId(),
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
