package com.tonelope.jobs.lt.photoalbum.commands;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tonelope.jobs.lt.photoalbum.model.Photo;
import com.tonelope.jobs.lt.photoalbum.service.PhotoService;

public class PhotoCommandsTest {

	private PhotoService photoService;
	private PhotoCommands testee;
	
	@Before
	public void init() {
		this.photoService = Mockito.mock(PhotoService.class);
		this.testee = new PhotoCommands(this.photoService);
	}
	
	@Test
	public void testGet() {
		Mockito.when(this.photoService.getAllPhotos()).thenReturn(this.getMockPhotos());
		List<String> actual = this.testee.get(false);
		assertThat(actual.toString()).isEqualTo("[[1] Photo 1]");
	}
	
	@Test
	public void testVerbose() {
		Mockito.when(this.photoService.getAllPhotos()).thenReturn(this.getMockPhotos());
		List<String> actual = this.testee.get(true);
		assertThat(actual.toString()).isEqualTo("[Photo(albumId=1, id=1, title=Photo 1, url=https://foo.bar/images/1.png, thumbnailUrl=https://foo.bar/images/1/thumb.png)]");
	}
	
	@Test
	public void testNullOrEmptyResponse() {
		Mockito.when(this.photoService.getAllPhotos()).thenReturn(null);
		List<String> actual = this.testee.get(false);
		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(1);
		assertThat(actual.get(0)).isEqualTo("No result(s) found.");
		
		Mockito.when(this.photoService.getAllPhotos()).thenReturn(new ArrayList<>());
		actual = this.testee.get(false);
		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(1);
		assertThat(actual.get(0)).isEqualTo("No result(s) found.");
	}
	
	@Test
	public void testGetByAlbumId() {
		Mockito.when(this.photoService.getPhotosByAlbumId(3L)).thenReturn(this.getMockPhotos());
		List<String> actual = this.testee.getByAlbumId(3L, false);
		assertThat(actual.toString()).isEqualTo("[[1] Photo 1]");
	}
	
	private List<Photo> getMockPhotos() {
		List<Photo> photos = new ArrayList<>();
		photos.add(new Photo(1L, new Long(1L), "Photo 1", "https://foo.bar/images/1.png", "https://foo.bar/images/1/thumb.png"));
		return photos;
	}
}
