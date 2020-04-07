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
public class PhotoServiceTest {

	private PhotoService testee;
	private ObjectMapper objectMapper;
	
	@Before
	public void init() {
		this.objectMapper = Mockito.mock(ObjectMapper.class);
		this.testee = new PhotoService(this.objectMapper);
	}
	
	@Test
	public void testGetAllPhotos() throws IOException {
		// given
		List<Photo> expected = new ArrayList<>();
		expected.add(new Photo(1L, new Long(1L), "Photo 1", "https://foo.bar/images/1.png", "https://foo.bar/images/1/thumb.png"));
		expected.add(new Photo(2L, new Long(2L), "Photo 2", "https://foo.bar/images/2.png", "https://foo.bar/images/2/thumb.png"));
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenReturn(expected);
		
		// when
		List<Photo> actual = this.testee.getAllPhotos();
		
		// then
		assertThat(actual).isEqualTo(expected);
		// validate API url is as expected
		ArgumentCaptor<URL> urlCaptor = ArgumentCaptor.forClass(URL.class);
		Mockito.verify(this.objectMapper).readValue(urlCaptor.capture(), Mockito.any(TypeReference.class));
		assertThat(urlCaptor.getValue().toString()).isEqualTo("https://jsonplaceholder.typicode.com/photos");
	}
	
	@Test
	public void testGetPhotosByAlbumId() throws IOException {
		// given
		List<Photo> expected = new ArrayList<>();
		expected.add(new Photo(1L, new Long(1L), "Photo 1", "https://foo.bar/images/1.png", "https://foo.bar/images/1/thumb.png"));
		expected.add(new Photo(1L, new Long(2L), "Photo 2", "https://foo.bar/images/2.png", "https://foo.bar/images/2/thumb.png"));
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenReturn(expected);
		
		// when
		List<Photo> actual = this.testee.getPhotosByAlbumId(3L);
		
		// then
		assertThat(actual).isEqualTo(expected);
		// validate API url is as expected
		ArgumentCaptor<URL> urlCaptor = ArgumentCaptor.forClass(URL.class);
		Mockito.verify(this.objectMapper).readValue(urlCaptor.capture(), Mockito.any(TypeReference.class));
		assertThat(urlCaptor.getValue().toString()).isEqualTo("https://jsonplaceholder.typicode.com/photos?albumId=3");
	}

	@Test(expected = ServiceException.class)
	public void testGetAllPhotosIOException() throws IOException {
		// given
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenThrow(new IOException());
		
		// when
		this.testee.getAllPhotos();
		
		// then (tested by JUnit exception clause)
	}
	
	@Test(expected = ServiceException.class)
	public void testGetPhotosByAlbumIdIOException() throws IOException {
		// given
		Mockito.when(this.objectMapper.readValue(Mockito.any(URL.class), Mockito.any(TypeReference.class))).thenThrow(new IOException());
		
		// when
		this.testee.getPhotosByAlbumId(3L);
		
		// then (tested by JUnit exception clause)
	}
}
