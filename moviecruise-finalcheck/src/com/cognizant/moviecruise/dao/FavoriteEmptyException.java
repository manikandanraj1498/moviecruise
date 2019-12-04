package com.cognizant.moviecruise.dao;

/**
 * 
 * @author ManiKandan V
 *
 */
public class FavoriteEmptyException extends Exception {
	private String message;

	public FavoriteEmptyException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
