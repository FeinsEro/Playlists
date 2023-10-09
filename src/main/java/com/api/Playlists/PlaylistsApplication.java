package com.api.Playlists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class PlaylistsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistsApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "Hello World!";
	}
}
