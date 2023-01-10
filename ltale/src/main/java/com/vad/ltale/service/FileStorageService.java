package com.vad.ltale.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.vad.ltale.entity.ImageRequest;
import com.vad.ltale.repository.ImageRepository;
import com.vad.ltale.repository.MessageRepository;
import com.vad.ltale.entity.Image;
import com.vad.ltale.entity.Message;
import com.vad.ltale.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements FileStorage{
    private final Path root = Paths.get("uploads/");
    private final MessageRepository messageRepository;
    private final ImageRepository imageRepository;

    private final BCrypt bCrypt;

    @Autowired
    public FileStorageService(MessageRepository messageRepository, ImageRepository imageRepository, BCrypt bCrypt) {
        this.messageRepository = messageRepository;
        this.imageRepository = imageRepository;
        this.bCrypt = bCrypt;

        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void saveAudio(MultipartFile file, Message message) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            Message temp = new Message(bCrypt.passwordEncoder().encode(message.getUri()), message.getDateCreated(), message.getDateChanged(), message.getImageId());
            messageRepository.save(temp);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void saveImg(ImageRequest imageRequest) {
        try {
            String img = bCrypt.passwordEncoder().encode(imageRequest.getImageUri());
            Files.copy(imageRequest.getFile().getInputStream(), Path.of(img));
            Image temp = new Image(img, imageRequest.getDateCreated(), imageRequest.getDateChanged());
            imageRepository.save(temp);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String directory) {
        try {
            Path file = Paths.get(directory);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
