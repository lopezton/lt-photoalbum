package com.tonelope.jobs.lt.photoalbum.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonelope.jobs.lt.photoalbum.model.Photo;

/**
 * <p> Unit test case for JsonPlaceholderPhotoServiceTest
 * @author Tony Lopez
 *
 */
public class JsonPlaceholderPhotoServiceTest {

	private JsonPlaceholderPhotoService testee;
	private ObjectMapper objectMapper;
	
	@Before
	public void init() {
		this.objectMapper = Mockito.mock(ObjectMapper.class);
		this.testee = new JsonPlaceholderPhotoService(this.objectMapper);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAllPhotos() throws IOException {
		List<Photo> expected = new ArrayList<>();
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenReturn(expected);
		List<Photo> actual = this.testee.getAllPhotos();
		assertThat(actual).isEqualTo(expected);
		
		// validate API url is as expected
		ArgumentCaptor<URL> urlCaptor = ArgumentCaptor.forClass(URL.class);
		Mockito.verify(this.objectMapper).readValue(urlCaptor.capture(), Mockito.any(TypeReference.class));
		assertThat(urlCaptor.getValue().toString()).isEqualTo("https://jsonplaceholder.typicode.com/photos");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetPhotosByAlbumId() throws IOException {
		List<Photo> expected = new ArrayList<>();
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenReturn(expected);
		List<Photo> actual = this.testee.getPhotosByAlbumId(3L);
		assertThat(actual).isEqualTo(expected);
		
		// validate API url is as expected
		ArgumentCaptor<URL> urlCaptor = ArgumentCaptor.forClass(URL.class);
		Mockito.verify(this.objectMapper).readValue(urlCaptor.capture(), Mockito.any(TypeReference.class));
		assertThat(urlCaptor.getValue().toString()).isEqualTo("https://jsonplaceholder.typicode.com/photos?albumId=3");
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = ServiceException.class)
	public void testGetAllPhotosIOException() throws IOException {
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenThrow(new IOException());
		this.testee.getAllPhotos();
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = ServiceException.class)
	public void testGetPhotosByAlbumIdIOException() throws IOException {
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenThrow(new IOException());
		this.testee.getPhotosByAlbumId(3L);
	}
}
