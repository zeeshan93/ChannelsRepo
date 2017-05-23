package com.compassites.channels.Exception;

public class AgeGroupException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public AgeGroupException() {
		super();
	}

	public AgeGroupException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
}
