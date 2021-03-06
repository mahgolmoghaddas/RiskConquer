package com.risk.exception;

/**
 * This class is used to handle Invalid map exceptions.
 * @author rahul
 * @version 1.0.0
 *
 */
public class InvalidMapException extends Exception {
	
	/**
	 * The @serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message to be printed as exception
	 */
	public InvalidMapException(String message) {
		super(message);
	}
}
