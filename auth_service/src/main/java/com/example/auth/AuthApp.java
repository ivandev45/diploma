package com.example.auth;

import com.example.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Import(SpringConfig.class)
public class AuthApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthApp.class, args);
	}
}
