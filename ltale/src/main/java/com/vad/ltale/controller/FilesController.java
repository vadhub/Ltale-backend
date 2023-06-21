package com.vad.ltale.controller;

import com.vad.ltale.entity.*;
import com.vad.ltale.repository.HashtagRepository;
import com.vad.ltale.repository.IconRepository;
import com.vad.ltale.repository.PostRepository;
import com.vad.ltale.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api-v1")
public class FilesController {

    private final FileStorage fileStorage;
    private final IconRepository iconRepository;
    private final PostRepository postRepository;
    private final HashtagRepository hashtagRepository;

    @Autowired
    public FilesController(FileStorage fileStorage, IconRepository iconRepository, PostRepository postRepository, HashtagRepository hashtagRepository) {
        this.fileStorage = fileStorage;
        this.iconRepository = iconRepository;
        this.postRepository = postRepository;
        this.hashtagRepository = hashtagRepository;
    }

    @PostMapping("/upload/audio")
    public ResponseEntity<Object> uploadAudio(@ModelAttribute FileRequest audio) {
        String messageResponse = "";
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fileStorage.saveAudio(audio, 0L));
        } catch (Exception e) {
            if (audio.getFile() == null) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("file is null"));
            }
            messageResponse = "Could not upload the file: " + audio.getFile().getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @PostMapping("/upload/image")
    public ResponseEntity<Object> uploadImage(@ModelAttribute FileRequest imageRequest) {
        String messageResponse = "";
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fileStorage.saveImage(imageRequest));
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + imageRequest.getFile().getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @PostMapping("/upload/icon")
    public ResponseEntity<Object> uploadIcon(@ModelAttribute FileRequest imageRequest, @RequestParam Long userId) {
        String messageResponse = "";
        try {
            Image image = fileStorage.saveImage(imageRequest);
            iconRepository.save(new Icon(image, userId));
            return ResponseEntity.status(HttpStatus.OK).body(image);
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + imageRequest.getFile().getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @PostMapping("/post/save")
    private ResponseEntity<Object> post(@ModelAttribute PostRequest postRequest) {
        String messageResponse = "";

        try {
            Image image = null;
            List<Audio> audioList = new ArrayList<>();
            List<Hashtag> hashtags = new ArrayList<>();
            if (postRequest.getImage() != null) {
                image = fileStorage.saveImage(new FileRequest(postRequest.getImage(),postRequest.getDateCreated(), postRequest.getDateChanged()));
            }

            for (int i = 0; i < postRequest.getListAudio().size(); i++) {
                Audio audio = fileStorage.saveAudio(new FileRequest(postRequest.getListAudio().get(i), postRequest.getDateCreated(), postRequest.getDateChanged()), postRequest.getListDuration().get(i));
                audioList.add(audio);
            }

            if (postRequest.getHashtags() != null) {
                for (String s : postRequest.getHashtags()) {
                    System.out.println(s);
                    hashtags.add(hashtagRepository.save(new Hashtag(s)));

                }
            }

            Post post = new Post(
                    postRequest.getUserId(),
                    image,
                    audioList,
                    postRequest.getDateCreated(),
                    postRequest.getDateChanged(),
                    hashtags
            );

            postRepository.save(post);
            return ResponseEntity.status(HttpStatus.OK).body(post);
        } catch (Exception e) {
            messageResponse = "Could not save post: " + postRequest.toString() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @GetMapping("/files/icon/search")
    @ResponseBody
    public ResponseEntity<Object> getIcon(@RequestParam Long userId) {
        Image image = iconRepository.getIconByUserId(userId).orElse(new Icon()).getImage();
        if (image == null) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("not found"));
        }
        Resource file = fileStorage.load("uploads/"+image.getImageUri());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/files/audio/search")
    @ResponseBody
    public ResponseEntity<Resource> getAudio(@RequestParam Long id) {
        Resource file = fileStorage.loadAudioById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/files/image/search")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@RequestParam Long id) {
        Resource file = fileStorage.loadImageById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
