package com.vad.ltale.upload;

import com.vad.ltale.dao.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileStorageService {
    @Autowired
    private MessageRepository messageRepository;


}
