package com.example.config;

import com.example.controller.FrontController;
import com.example.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by ivan on 09.06.18.
 */
@Configuration
public class SpringConfig {

    @Autowired
    private Environment env;

    @Bean
    public FrontController mediaController(){
        return new FrontController(mediaService());
    }

    @Bean
    public MediaService mediaService(){
        return new MediaService(env);
    }
}
