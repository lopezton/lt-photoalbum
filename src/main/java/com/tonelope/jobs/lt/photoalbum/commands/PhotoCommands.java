package com.tonelope.jobs.lt.photoalbum.commands;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.tonelope.jobs.lt.photoalbum.model.Photo;
import com.tonelope.jobs.lt.photoalbum.service.PhotoService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@ShellComponent
@Getter
@Setter
@RequiredArgsConstructor
public class PhotoCommands {

	@Autowired
	private final PhotoService photoService;

	@ShellMethod("Retrieve all photo metadata from the system.")
	public List<String> get(@ShellOption(help = "verbose", value = { "-v", "--verbose" }) boolean v) {
		return getResults(this.photoService.getAllPhotos(), v);
	}

	@ShellMethod("Retrieve all photo metadata from the system.")
	public List<String> getByAlbumId(@ShellOption(help = "the album id for which to retrieve photos for.") Long albumId,
			@ShellOption(help = "verbose", value = { "-v", "--verbose" }) boolean v) {
		return getResults(this.photoService.getPhotosByAlbumId(albumId), v);
	}

	private List<String> getResults(List<Photo> photos, boolean v) {
		if (null == photos || photos.isEmpty()) {
			return Arrays.asList("No result(s) found.");
		}
		Function<Photo, String> fmt = v ? Photo::toString : PhotoCommands::fmtIdAndTitle;
		return photos.stream().map(fmt).collect(Collectors.toList());
	}

	public static String fmtIdAndTitle(Photo p) {
		return "[" + p.getId() + "] " + p.getTitle();
	}
}
