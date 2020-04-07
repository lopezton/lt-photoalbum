package com.tonelope.jobs.lt.photoalbum.service;

/**
 * <p>
 * A wrapper exception intended for use when encountering exceptions within the
 * application's "service" layer.
 * 
 * @author Tony Lopez
 *
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
