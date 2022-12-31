package com.vad.ltale.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.vad.ltale.dao.ImageRepository;
import com.vad.ltale.dao.MessageRepository;
import com.vad.ltale.entity.ImageUser;
import com.vad.ltale.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements FileStorage{
    private Path root;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ImageRepository imageRepository;

    public void createDirectory(String directory) {
        try {
            root = Paths.get("uploads"+"/"+directory);
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void saveAudio(MultipartFile file, String title, int idUser) {
        try {
            createDirectory(idUser+"/audio");
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            Message temp = new Message(title,file.getOriginalFilename(), idUser);
            messageRepository.save(temp);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void saveImg(MultipartFile file,  int idUser) {
        try {
            createDirectory(idUser+"/image");
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            ImageUser temp = new ImageUser(idUser, file.getOriginalFilename());
            imageRepository.save(temp);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filename, String directory) {
        try {
            root = Paths.get("uploads/"+directory);
            Path file = root.resolve(filename);
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
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            root = Paths.get("uploads");
            return Files.walk(this.root, 2).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
