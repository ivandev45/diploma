package com.example.controller;

import com.example.service.AuthService;
import com.example.service.MediaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by ivan on 09.06.18.
 */
@RestController
public class MediaController {

    Logger log = LogManager.getLogger(MediaController.class);

    private final MediaService mediaService;
    private final AuthService authService;

    public MediaController(MediaService mediaService,
                           AuthService authService) {
        this.mediaService = mediaService;
        this.authService = authService;
    }

    @RequestMapping(value = "/image/{fileName}", method = RequestMethod.GET)
    public ResponseEntity getImage(@PathVariable String fileName,
                                   @RequestParam String userId,
                                   @RequestParam String pwdHash) throws IOException {
        log.info("request : filename -> {}, userId -> {}, passwordHash -> {}", fileName, userId, pwdHash);
        if (authService.isCorrectPassword(userId, pwdHash)) {
            return new ResponseEntity(mediaService.getImage(userId, fileName), HttpStatus.OK);
        } else {
            return new ResponseEntity("Not authorized", HttpStatus.UNAUTHORIZED);
        }
    }

}
