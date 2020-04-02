package com.tonelope.jobs.lt.photoalbum.service;

import java.util.List;

import com.tonelope.jobs.lt.photoalbum.model.Photo;

/**
 * Base interface for retrieving photos.
 * 
 * @author Tony Lopez
 *
 */
public interface PhotoService {

	/**
	 * <p>
	 * Retrieve all photos from the configured service provider.
	 */
	List<Photo> getAllPhotos();

	/**
	 * <p>
	 * Retrieve all photos from the configured service provider if the photo's album
	 * id matches the given {@code albumId}.
	 * 
	 * @param albumId the album id to match against
	 */
	List<Photo> getPhotosByAlbumId(Long albumId);
}
