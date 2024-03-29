package com.vad.ltale.service;

import com.vad.ltale.entity.Audio;
import com.vad.ltale.entity.FileRequest;
import com.vad.ltale.entity.Image;
import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FileStorage {

    void init();

    Audio saveAudio(FileRequest audioRequest, Long duration);

    Image saveImage(FileRequest imageRequest);

    Resource load(String directory);

    Resource loadImageById(Long id);

    Resource loadAudioById(Long id);

    List<Audio> getAudiosById(List<Long> id);

    Image getImageById(Long id);

    Stream<Path> loadAll();
}
