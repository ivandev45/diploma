package com.example.config;

import com.example.controller.MediaController;
import com.example.repository.MediaRepository;
import com.example.service.AuthService;
import com.example.service.MediaService;
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
    private Environment env;
    @Autowired
    private MediaRepository mediaRepository;

    @Bean
    public MediaService mediaService(){
        return new MediaService(mediaRepository, env);
    }

    @Bean
    public MediaController mediaController(){
        return new MediaController(mediaService(), authService());
    }

    @Bean
    public AuthService authService(){
        return new AuthService(env);
    }
}
