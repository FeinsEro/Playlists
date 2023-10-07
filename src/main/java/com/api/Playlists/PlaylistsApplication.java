package com.api.Playlists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class PlaylistsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistsApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "Hello World!";
	}
}
