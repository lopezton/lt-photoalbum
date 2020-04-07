package com.tonelope.jobs.lt.photoalbum.integ;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonelope.jobs.lt.photoalbum.model.Photo;
import com.tonelope.jobs.lt.photoalbum.service.PhotoService;

/**
 * Integration test for Photos API. Makes real calls to the services under test
 * to validate they are working as expected.
 * 
 * @author Tony Lopez
 *
 */
public class PhotosApiIntegrationTest {

	private PhotoService photoService;

	@Before
	public void init() {
		this.photoService = new PhotoService(new ObjectMapper());
	}

	@Test
	public void testGetPhotosContract() {
		List<Photo> photos = this.photoService.getAllPhotos();
		assertThat(photos).isNotNull();
		assertThat(photos).isNotEmpty();
	}

	@Test
	public void testGetPhotosByAlbumId() {
		Long albumId = 3L;
		List<Photo> photos = this.photoService.getPhotosByAlbumId(albumId);
		assertThat(photos).isNotNull();
		assertThat(photos).isNotEmpty();
		if (photos.stream().filter(p -> p.getAlbumId() != albumId).count() != 0) {
			fail("API returned photos from album that differed from given album(" + albumId + ")");
		}
	}
}
