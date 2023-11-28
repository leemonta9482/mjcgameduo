package com.javaproject.mjcgameduo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MjcgameduoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MjcgameduoApplication.class, args);
	}
}