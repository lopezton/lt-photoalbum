package com.tonelope.jobs.lt.photoalbum.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonelope.jobs.lt.photoalbum.model.Photo;

/**
 * Sample JSON Photo service that utilize the mock services at
 * https://jsonplaceholder.typicode.com /photos endpoint to retrieve some sample
 * data for images.
 * 
 * @author Tony Lopez
 *
 */
public class PhotoService {

	public static final String API_URL = "https://jsonplaceholder.typicode.com";
	public static final String PHOTOS_ENDPOINT = API_URL + "/photos";

	private ObjectMapper objectMapper;

	public PhotoService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public List<Photo> getAllPhotos() {
		try {
			return this.objectMapper.readValue(new URL(PHOTOS_ENDPOINT), new TypeReference<List<Photo>>() {
			});
		} catch (IOException e) {
			throw new RuntimeException("Failed to retrieve photos.", e);
		}
	}

	public List<Photo> getPhotosByAlbumId(Long albumId) {
		try {
			return this.objectMapper.readValue(new URL(PHOTOS_ENDPOINT + "?albumId=" + albumId),
					new TypeReference<List<Photo>>() {
					});
		} catch (IOException e) {
			throw new RuntimeException("Failed to retrieve photos with albumId \"" + albumId + "\".", e);
		}
	}

}
