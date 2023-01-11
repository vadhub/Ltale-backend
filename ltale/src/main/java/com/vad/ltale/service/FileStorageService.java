package com.vad.ltale.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.vad.ltale.entity.Audio;
import com.vad.ltale.entity.FileRequest;
import com.vad.ltale.entity.ImageRequest;
import com.vad.ltale.repository.ImageRepository;
import com.vad.ltale.repository.MessageRepository;
import com.vad.ltale.entity.Image;
import com.vad.ltale.security.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService implements FileStorage{
    private final Path root = Paths.get("uploads");
    private final MessageRepository messageRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public FileStorageService(MessageRepository messageRepository, ImageRepository imageRepository) {
        this.messageRepository = messageRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void saveAudio(FileRequest request) {
        try {
            String audio = Hash.digest(request.getFile().getName());
            Files.copy(request.getFile().getInputStream(), this.root.resolve(audio));
            Audio temp = new Audio(audio, request.getDateCreated(), request.getDateChanged());

        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void saveImage(ImageRequest imageRequest) {
        try {
            String img = Hash.digest(imageRequest.getFile().getName());
            Files.copy(imageRequest.getFile().getInputStream(), root.resolve(img));
            Image temp = new Image(img, imageRequest.getDateCreated(), imageRequest.getDateChanged(), imageRequest.getIsIcon());
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
