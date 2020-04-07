package com.tonelope.jobs.lt.photoalbum.commands;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.tonelope.jobs.lt.photoalbum.model.Photo;
import com.tonelope.jobs.lt.photoalbum.service.PhotoService;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@ShellComponent
@Setter
@RequiredArgsConstructor
public class PhotoCommands {

	@Autowired
	private final PhotoService photoService;

	@ShellMethod("Retrieve all photo metadata from the system.")
	public List<String> get(@ShellOption(help = "verbose", value = { "-v", "--verbose" }) boolean verbose) {
		return getResults(this.photoService.getAllPhotos(), verbose);
	}

	@ShellMethod("Retrieve all photo metadata from the system.")
	public List<String> getByAlbumId(@ShellOption(help = "the album id for which to retrieve photos for.") Long albumId,
			@ShellOption(help = "verbose", value = { "-v", "--verbose" }) boolean verbose) {
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
