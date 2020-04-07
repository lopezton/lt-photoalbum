package com.tonelope.jobs.lt.photoalbum;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonelope.jobs.lt.photoalbum.commands.PhotoCommands;
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

	public static final int ALBUM_ID_ARG_IDX = 0;
	public static final String FLAG_PREFIX = "-";
	public static final String[] FLAG_KEYS_VERBOSE = new String[] { "-v", "--verbose" };

	private PhotoAlbumApplication() {

	}

	public static void main(String[] args) {
		PhotoService photoService = new PhotoService(new ObjectMapper());
		PhotoCommands photoCommands = new PhotoCommands(photoService);
		
		// arguments
		Long albumId = null;
		
		// options
		boolean verbose = false;
		
		if (null == args || args.length == 0) {
			photoCommands.get(verbose).forEach(System.out::println);

		} else {
			verbose = Boolean.valueOf(isFlagPresent(args, new String[] { "-v", "--verbose" }));

			String sAlbumId = getArgumentValue(args, ALBUM_ID_ARG_IDX);
			if (null == sAlbumId) {
				photoCommands.get(verbose).forEach(System.out::println);
				
			} else {
				try {
					albumId = Long.valueOf(getArgumentValue(args, ALBUM_ID_ARG_IDX));
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Please provide a numeric value for albumId.");
				}
				photoCommands.getByAlbumId(albumId, verbose).forEach(System.out::println);
				
			}
		}
	}

	/**
	 * <p>
	 * Determine by string comparison if a given string within {@code flagKeys}
	 * exists within {@code args}.
	 * 
	 * @param args     the arguments to check if a flag exists in
	 * @param flagKeys the search set
	 * @return {@code true} if found, {@code false} otherwise
	 */
	private static boolean isFlagPresent(String[] args, String[] flagKeys) {
		for (String flagKey : flagKeys) {
			if (Arrays.stream(args).anyMatch(flagKey::equals)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <p>
	 * Retrieve the value of {@code args} at index: {@code idx}. Returns
	 * {@code null} if {@link #FLAG_PREFIX} is found at the given index in the
	 * array.
	 * 
	 * @param args the arguments to check if a flag exists in
	 * @param idx  the argument index for which to retrieve a value
	 * @return the value of the identified argument, {@code null} otherwise.
	 */
	private static String getArgumentValue(String[] args, int idx) {
		if (idx < 0 || idx >= args.length) {
			return null;
		}
		String value = args[idx];
		if (null == value || value.startsWith(FLAG_PREFIX)) {
			return null;
		}
		return value;
	}
}
