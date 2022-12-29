package com.vad.ltale.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorage {

    void saveAudio(MultipartFile file, String title, int userId);

    void saveImg(MultipartFile file, int userId);

    Resource load(String filename, String user);

    void deleteAll();

    Stream<Path> loadAll();
}
