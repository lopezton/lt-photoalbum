package com.tonelope.jobs.lt.photoalbum.commands;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.tonelope.jobs.lt.photoalbum.model.Photo;
import com.tonelope.jobs.lt.photoalbum.service.PhotoService;

/**
 * <p>
 * Defines all shell commands that utilize the {@link PhotoService}.
 * 
 * @author Tony Lopez
 */
public class PhotoCommands {

	private PhotoService photoService;
	
	public PhotoCommands(PhotoService photoService) {
		this.photoService = photoService;
	}

	public List<String> get(boolean verbose) {
		return getResults(this.photoService.getAllPhotos(), verbose);
	}

	public List<String> getByAlbumId(Long albumId, boolean verbose) {
		return getResults(this.photoService.getPhotosByAlbumId(albumId), verbose);
	}

	private List<String> getResults(List<Photo> photos, boolean verbose) {
		if (null == photos || photos.isEmpty()) {
			return Collections.singletonList("No result(s) found.");
		}

		Function<Photo, String> fmt = Photo::toString;
		if (!verbose) {
			fmt = p -> "[" + p.getId() + "] " + p.getTitle();
		}

		return photos.stream().map(fmt).collect(Collectors.toList());
	}
}
