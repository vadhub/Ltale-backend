package com.vad.ltale.service;

import com.vad.ltale.entity.Post;
import com.vad.ltale.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> getAllPost(Long currentUserId, int page, int size, SortTypes sortTypes) {

        Sort sort = null;

        switch (sortTypes) {
            case DATE_DESC -> sort = Sort.by(Sort.Direction.DESC, "dateCreated");
            case DATE_ASC -> sort = Sort.by(Sort.Direction.ASC, "dateCreated");
            case LIKE -> sort = Sort.by(Sort.Direction.DESC, "countLike");
        }

        return postRepository.findAll(PageRequest.of(page, size, sort));
    }
}
