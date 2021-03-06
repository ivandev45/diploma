package com.example.config;

import com.example.controller.AuthController;
import com.example.repository.UserRepository;
import com.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ivan on 09.06.18.
 */
@Configuration
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class SpringConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public AuthController authController(){
        return new AuthController(authService());
    }

    @Bean
    public AuthService authService(){
        return new AuthService(userRepository);
    }
}
