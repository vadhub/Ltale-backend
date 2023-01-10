package com.vad.ltale.controller;

import com.vad.ltale.entity.Image;
import com.vad.ltale.entity.Message;
import com.vad.ltale.entity.ResponseMessage;
import com.vad.ltale.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api-v1")
public class FilesController {

    private final FileStorage fileStorage;

    @Autowired
    public FilesController(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadAudio(@RequestPart("file") MultipartFile file, @RequestBody Message message) {
        String messageResponse = "";
        try {
            fileStorage.saveAudio(file, message);
            messageResponse = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(messageResponse));
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadImage(@RequestPart("file") MultipartFile file, @RequestBody Image image) {
        String messageResponse = "";
        try {
            fileStorage.saveImg(file, image);
            messageResponse = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(messageResponse));
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @GetMapping("/files/search")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@RequestParam String userId, @RequestParam String directory, @RequestParam String filename) {
        Resource file = fileStorage.load("uploads/"+userId+"/"+directory+"/"+filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
