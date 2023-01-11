package com.vad.ltale.controller;

import com.vad.ltale.entity.FileRequest;
import com.vad.ltale.entity.ImageRequest;
import com.vad.ltale.entity.ResponseMessage;
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

    @Autowired
    public FilesController(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    @PostMapping("/upload/audio")
    public ResponseEntity<ResponseMessage> uploadAudio(@ModelAttribute FileRequest audio) {
        String messageResponse = "";
        try {
            fileStorage.saveAudio(audio);
            messageResponse = "Uploaded the file successfully: " + audio.getFile().getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(messageResponse));
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + audio.getFile().getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @PostMapping("/upload/image")
    public ResponseEntity<ResponseMessage> uploadImage(@ModelAttribute ImageRequest imageRequest) {
        String messageResponse = "";
        try {
            fileStorage.saveImage(imageRequest);
            messageResponse = "Uploaded the file successfully: " + imageRequest.getFile().getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(messageResponse));
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + imageRequest.getFile().getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @GetMapping("/files/search")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@RequestParam String filename) {
        Resource file = fileStorage.load("uploads/"+filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
