package com.example.service;

import com.example.entity.ImageEntity;
import com.example.repository.MediaRepository;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ivan on 09.06.18.
 */
public class MediaService {
    private final MediaRepository mediaRepository;
    private final Environment env;

    public MediaService(MediaRepository mediaRepository,
                        Environment env) {
        this.mediaRepository = mediaRepository;
        this.env = env;
    }

    public byte[] getImage(String userId, String fileName) throws IOException {
        ImageEntity entity = mediaRepository.findImageEntityByUserIdAndImageFileName(userId, fileName);
        if (entity != null) {
            return Files.readAllBytes(resolveImageFilePath(fileName));
        } else {
            return null;
        }
    }

    private Path resolveImageFilePath(String fileName){
        String workDir = env.getProperty("work.dir", "/microservices/workdir");
        return Paths.get(workDir, fileName);
    }
}
