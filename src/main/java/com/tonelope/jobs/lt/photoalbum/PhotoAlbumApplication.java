package com.tonelope.jobs.lt.photoalbum;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * A simple console application that retrieves photo information based on given
 * inputs.
 * <p>
 * This is an application written as a technical showcase for Lean Techniques.
 * 
 * @author Tony Lopez
 *
 */
@SpringBootApplication
public class PhotoAlbumApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAlbumApplication.class, args);
	}

	@Bean
	public PromptProvider myPromptProvider() {
		return () -> new AttributedString("photo-album:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
