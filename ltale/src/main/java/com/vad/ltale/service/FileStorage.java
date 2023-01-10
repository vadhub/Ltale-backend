package com.vad.ltale.service;

import com.vad.ltale.entity.Image;
import com.vad.ltale.entity.Message;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorage {

    void saveAudio(MultipartFile file, Message message);

    void saveImg(MultipartFile file, Image image);

    Resource load(String directory);

    Stream<Path> loadAll();
}
