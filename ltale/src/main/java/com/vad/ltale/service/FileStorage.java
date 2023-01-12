package com.vad.ltale.service;

import com.vad.ltale.entity.Audio;
import com.vad.ltale.entity.FileRequest;
import com.vad.ltale.entity.Image;
import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorage {

    void init();

    Audio saveAudio(FileRequest request);

    Image saveImage(FileRequest imageRequest);

    Resource load(String directory);

    Stream<Path> loadAll();
}
