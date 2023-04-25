package com.vad.ltale.service;

import com.vad.ltale.entity.*;
import com.vad.ltale.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //todo refactoring
        Post response;
//        if (post.getImage() != null && !post.getImage().isEmpty()) {
//
//        } else {
//            response = postRepository.save(new Post(
//                            post.getUserId(),
//                            new Date(post.getDateCreated()),
//                            new Date(post.getDateChanged())
//                    )
//            );
//        }

        //Post finalResponse = response;

//        IntStream.range(0, post.getAudio().size())
//                .mapToObj(i -> new PostAndAudio(
//                        finalResponse.getId(),
//                        fileStorage.saveAudio(new FileRequest(post.getAudio().get(i)), post.getDuration().get(i)).getId())
//                ).forEach(postAndAudioRepository::save);

        return null;
    }

    @Override
    public NestedPost getOne(Long id) {

        return null;
//        return new NestedPost(
//                fileStorage.getImageById(post.getImageId()),
//                post.getDateCreated(),
//                post.getDateChanged(),
//                fileStorage.getAudiosById(ids)
//        );
    }

    @Override
    public List<NestedPost> getByUserId(Long id) {

        return null;

//        List<Post> postIds = postRepository.findAllByUserId(id);
//
//        return postIds.stream().map(
//                post -> new NestedPost(
//                        fileStorage.getImageById(post.getImageId()),
//                        post.getDateCreated(),
//                        post.getDateChanged(),
//                        fileStorage.getAudiosById(
//                                postAndAudioRepository.getPostAndAudiosByPostId(post.getId()).stream().map(PostAndAudio::getAudioId).toList()
//                        )
//                )
//        ).toList();
    }
}
