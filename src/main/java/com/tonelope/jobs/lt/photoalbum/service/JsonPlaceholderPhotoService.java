package com.tonelope.jobs.lt.photoalbum.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonelope.jobs.lt.photoalbum.model.Photo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Sample JSON Photo service that utilize the mock services at
 * https://jsonplaceholder.typicode.com /photos endpoint to retrieve some sample
 * data for images.
 * 
 * @author Tony Lopez
 *
 */
@Setter
@Getter
@RequiredArgsConstructor
public class JsonPlaceholderPhotoService implements PhotoService {

	public static String API_URL = "https://jsonplaceholder.typicode.com";
	public static String PHOTOS_ENDPOINT = API_URL + "/photos";

	private final ObjectMapper objectMapper;

	@Override
	public List<Photo> getAllPhotos() {
		try {
			return this.objectMapper.readValue(new URL(PHOTOS_ENDPOINT), new TypeReference<List<Photo>>() {
			});
		} catch (IOException e) {
			throw new ServiceException("Failed to retrieve photos.", e);
		}
	}

	@Override
	public List<Photo> getPhotosByAlbumId(Long albumId) {
		try {
			URL url = new URL(PHOTOS_ENDPOINT + "?albumId=" + albumId);
			return this.objectMapper.readValue(url, new TypeReference<List<Photo>>() {
			});
		} catch (IOException e) {
			throw new ServiceException("Failed to retrieve photos with albumId \"" + albumId + "\".", e);
		}
	}

}
