package com.example.controller;

import com.example.service.MediaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by ivan on 09.06.18.
 */
@RestController
public class FrontController {

    Logger log = LogManager.getLogger(FrontController.class);

    private final MediaService mediaService;

    public FrontController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @RequestMapping(value = "/image/{fileName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName,
                                   @RequestParam String userId,
                                   @RequestParam String pwdHash) throws IOException {
        log.info("request : fileName -> {}, userId -> {}, passwordHash -> {}", fileName, userId, pwdHash);
        return new ResponseEntity(mediaService.getImage(fileName, userId, pwdHash), HttpStatus.OK);
    }

}
