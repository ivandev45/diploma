package com.example.service;

import com.example.repository.UserRepository;

/**
 * Created by ivan on 09.06.18.
 */
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isCorrectPassword(String userId, String pwdHash){
        return userRepository.findUserEntityByUserId(userId).getPassHash().equals(pwdHash);
    }
}
