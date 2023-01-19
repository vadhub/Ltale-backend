package com.vad.ltale.controller;

import com.vad.ltale.entity.*;
import com.vad.ltale.repository.IconRepository;
import com.vad.ltale.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api-v1")
public class FilesController {

    private final FileStorage fileStorage;
    private final IconRepository iconRepository;

    @Autowired
    public FilesController(FileStorage fileStorage, IconRepository iconRepository) {
        this.fileStorage = fileStorage;
        this.iconRepository = iconRepository;
    }

    @PostMapping("/upload/audio")
    public ResponseEntity<Object> uploadAudio(@ModelAttribute FileRequest audio) {
        String messageResponse = "";
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fileStorage.saveAudio(audio));
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

    @GetMapping("/files/search/icon")
    @ResponseBody
    public ResponseEntity<Resource> getIcon(@RequestParam Long userId) {
        Image image = iconRepository.getIconByUserId(userId).getImage();
        Resource file = fileStorage.load("uploads/"+image.getImageUri());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/files/search")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@RequestParam Long userId) {
        Image image = iconRepository.getIconByUserId(userId).getImage();
        Resource file = fileStorage.load("uploads/"+image.getImageUri());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
