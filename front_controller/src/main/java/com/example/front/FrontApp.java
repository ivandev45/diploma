package com.example.front;

import com.example.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringConfig.class)
public class FrontApp {

	public static void main(String[] args) {
		SpringApplication.run(FrontApp.class, args);
	}
}
