/**
 * 
 */
package com.rushi.microservice.hotel.exceptions;

/**
 * 
 */
public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3887198518961396822L;

	public ResourceNotFoundException() {
		super("Resource Not Found");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
