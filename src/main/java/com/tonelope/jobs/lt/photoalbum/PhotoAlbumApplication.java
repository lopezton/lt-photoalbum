package com.tonelope.jobs.lt.photoalbum;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonelope.jobs.lt.photoalbum.model.Photo;
import com.tonelope.jobs.lt.photoalbum.service.JsonPlaceholderPhotoService;
import com.tonelope.jobs.lt.photoalbum.service.PhotoService;

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
public class PhotoAlbumApplication {

	public static void main(String[] args) {
		ObjectMapper om = new ObjectMapper();
		PhotoService photoService = new JsonPlaceholderPhotoService(om);
		
		// retrieve the photos
		List<Photo> photos;
		if (args.length > 0) {
			Long albumId = null;
			try {
				albumId = Long.valueOf(args[0]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Please provide a numeric value for albumId.");
			}
			photos = photoService.getPhotosByAlbumId(albumId);
		} else {
			photos = photoService.getAllPhotos();
		}
		
		// display the photos found
		if (null != photos && !photos.isEmpty()) {
			photos.forEach(PhotoAlbumApplication::printPhotoDetails);
		} else {
			System.out.println("No photos found.");
		}
	}
	
	public static void printPhotoDetails(Photo p) {
		System.out.println("[" + p.getId() + "] " + p.getTitle());
	}
}
