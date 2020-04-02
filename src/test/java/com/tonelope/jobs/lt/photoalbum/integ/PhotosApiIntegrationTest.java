package com.tonelope.jobs.lt.photoalbum.integ;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonelope.jobs.lt.photoalbum.model.Photo;
import com.tonelope.jobs.lt.photoalbum.service.JsonPlaceholderPhotoService;
import com.tonelope.jobs.lt.photoalbum.service.PhotoService;

/**
 * Integration test for Photos API
 * 
 * @author Tony Lopez
 *
 */
public class PhotosApiIntegrationTest {

	private PhotoService photoService;
	
	@Before
	public void init() {
		this.photoService = new JsonPlaceholderPhotoService(new ObjectMapper());
	}

	@Test
	public void testGetPhotosContract() throws IOException {
		List<Photo> photos = this.photoService.getAllPhotos();
		assertThat(photos).isNotNull();
		assertThat(photos).isNotEmpty();
	}

	@Test
	public void testGetPhotosByAlbumId()
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		Long albumId = 3L;
		List<Photo> photos = this.photoService.getPhotosByAlbumId(albumId);
		assertThat(photos).isNotNull();
		assertThat(photos).isNotEmpty();
		if (photos.stream().filter(p -> p.getAlbumId() != albumId).count() != 0) {
			fail("API returned photos from album that differed from given album(" + albumId + ")");
		}
	}
}
