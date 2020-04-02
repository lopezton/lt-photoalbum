package com.tonelope.jobs.lt.photoalbum.model;

import lombok.Data;

/**
 * <p>
 * Domain object for representation of a photo object.
 * 
 * @author Tony Lopez
 *
 */
@Data
public class Photo {

	private Long albumId;
	private Long id;
	private String title;
	private String url;
	private String thumbnailUrl;
}
