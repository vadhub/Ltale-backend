package com.vad.ltale.service;

import com.vad.ltale.entity.Message;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorage {
    void init();

    void save(MultipartFile file, Message message);

    Resource load(String filename);

    void deleteAll();

    Stream<Path> loadAll();
}
