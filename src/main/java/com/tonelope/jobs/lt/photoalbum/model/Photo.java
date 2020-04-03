package com.tonelope.jobs.lt.photoalbum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Domain object for representation of a photo object.
 * 
 * @author Tony Lopez
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

	private Long albumId;
	private Long id;
	private String title;
	private String url;
	private String thumbnailUrl;
}
