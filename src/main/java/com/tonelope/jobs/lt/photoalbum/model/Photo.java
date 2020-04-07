package com.tonelope.jobs.lt.photoalbum.model;

/**
 * <p>
 * Domain object for representation of a photo object.
 * 
 * @author Tony Lopez
 *
 */
public class Photo {

	private Long albumId;
	private Long id;
	private String title;
	private String url;
	private String thumbnailUrl;

	public Photo() {

	}

	public Photo(Long albumId, Long id, String title, String url, String thumbnailUrl) {
		this.albumId = albumId;
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public Long getId() {
		return id;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Photo(");
		return sb.append("albumId=").append(this.albumId).append(", ").append("id=").append(this.id).append(", ")
				.append("title=").append(this.title).append(", ").append("url=").append(this.url).append(", ")
				.append("thumbnailUrl=").append(this.thumbnailUrl).append(")").toString();
	}
}
