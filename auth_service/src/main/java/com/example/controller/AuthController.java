package com.example.controller;

import com.example.service.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ivan on 09.06.18.
 */
@RestController
public class AuthController {

    Logger log = LogManager.getLogger(AuthController.class);

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getImage(@RequestParam String userId,
                                   @RequestParam String pwdHash) {
        log.info("request : userId -> {}, passwordHash -> {}", userId, pwdHash);
        return new ResponseEntity<>(authService.isCorrectPassword(userId, pwdHash), HttpStatus.OK);
    }

}
