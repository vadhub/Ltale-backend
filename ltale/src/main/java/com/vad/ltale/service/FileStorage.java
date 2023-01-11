package com.vad.ltale.service;

import com.vad.ltale.entity.FileRequest;
import com.vad.ltale.entity.ImageRequest;
import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorage {

    void init();

    void saveAudio(FileRequest request);

    void saveImage(ImageRequest imageRequest);

    Resource load(String directory);

    Stream<Path> loadAll();
}
